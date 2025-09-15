package com.ingtjxoqg.spark.utils

import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {
  lazy val spark: SparkSession = {
    SparkSession.builder()
      .appName("SparkScalaCoding")
      .master("local[*]")
      .getOrCreate()
  }
}
