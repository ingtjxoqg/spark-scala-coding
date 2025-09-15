package com.ingtjxoqg.spark.app

import com.ingtjxoqg.spark.ingestion.LogTransformer
import com.ingtjxoqg.spark.utils.SparkSessionBuilder

object LogIngestionMainApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSessionBuilder.spark

    val filePath = "src/main/resources/sample_logs.txt"
    val resultDF = LogTransformer.transform(filePath, spark)

    resultDF.printSchema()
    resultDF.show(truncate = false)

    spark.stop()
  }
}

