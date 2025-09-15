package com.ingtjxoqg.spark.ingestion

import com.ingtjxoqg.spark.utils.JsonUtils
import org.apache.spark.sql.{DataFrame, SparkSession}

object LogTransformer {

  /**
   * Full pipeline:
   * - Read log file
   * - Parse details dynamically
   * - Explode key-value pairs
   */
  def transform(filePath: String, spark: SparkSession): DataFrame = {
    val rawDF = LogReader.readLogFile(filePath, spark)
    val dfWithMap = JsonUtils.parseDetailsColumn(rawDF, "details")
    val explodedDF = JsonUtils.explodeDetailsMap(dfWithMap)

    explodedDF
  }
}
