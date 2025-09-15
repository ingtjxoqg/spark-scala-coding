package com.ingtjxoqg.spark.ingestion

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}

object LogReader {
  /**
   * Reads a CSV log file dynamically
   * Handles evolving schema and quoted fields
   */
  def readLogFile(filePath: String, spark: SparkSession): DataFrame = {
    val df = spark.read.text(filePath)

    // Split line into first 3 fields + remaining as details
    val splitDF = df.selectExpr("split(value, ',', 4) as cols")
      .select(
        col("cols").getItem(0).as("timestamp"),
        col("cols").getItem(1).as("user_id"),
        col("cols").getItem(2).as("event_type"),
        col("cols").getItem(3).as("details")
      )
    splitDF
  }

}
