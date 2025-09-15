package com.ingtjxoqg.spark.app

import com.ingtjxoqg.spark.ingestion.LogTransformer
import org.scalatest.funsuite.AnyFunSuite
import com.ingtjxoqg.spark.utils.SparkSessionBuilder


class LogIngestionTransformerSpec extends AnyFunSuite {

  val spark = SparkSessionBuilder.spark
  import spark.implicits._

  test("Basic log file should parse and explode details correctly") {
    val df = LogTransformer.transform("src/test/resources/test_log_basic.txt", spark)

    // Check schema
    assert(df.columns.contains("timestamp"))
    assert(df.columns.contains("user_id"))
    assert(df.columns.contains("event_type"))
    assert(df.columns.contains("detail_key"))
    assert(df.columns.contains("detail_value"))

    // Check some expected keys and values
    val keys = df.select("detail_key").as[String].collect()
    val values = df.select("detail_value").as[String].collect()

    assert(keys.contains("device"))
    assert(keys.contains("os"))
    assert(keys.contains("item_id"))
    assert(keys.contains("duration"))
    assert(values.contains("mobile"))
    assert(values.contains("android"))
    assert(values.contains("product789"))
    assert(values.contains("30"))
  }

  test("Log file with missing details should not fail") {
    val df = LogTransformer.transform("src/test/resources/test_log_missing.txt", spark)

    // Rows with empty or missing details should have null detail_key/detail_value
    val nullCount = df.filter($"detail_key".isNull && $"detail_value".isNull).count()
    assert(nullCount >= 1)

    // Check that present keys are still extracted
    val keys = df.select("detail_key").as[String].collect()
    assert(keys.contains("item_id"))
  }

  test("Log file with complex details should explode all keys") {
    val df = LogTransformer.transform("src/test/resources/test_log_complex.txt", spark)

    val expectedKeys = Seq("item_id", "price", "currency", "duration", "device")
    val keys = df.select("detail_key").as[String].collect()
    expectedKeys.foreach(k => assert(keys.contains(k)))

    val values = df.select("detail_value").as[String].collect()
    assert(values.contains("499.99"))
    assert(values.contains("USD"))
    assert(values.contains("tablet"))
  }

}
