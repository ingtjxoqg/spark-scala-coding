package com.ingtjxoqg.spark.utils

import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

object JsonUtils {

  /**
   * Parse the details column as MapType
   */
  def parseDetailsColumn(df: DataFrame, detailsCol: String, outputCol: String = "details_map"): DataFrame = {
    df.withColumn(
      "details_map",
      when(col(detailsCol).isNotNull && length(trim(col(detailsCol))) > 0,
        from_json(col(detailsCol).cast("string"), MapType(StringType, StringType))
      ).otherwise(map()))
  }

  /**
   * Explode MapType column into key-value rows
   */
  def explodeDetailsMap(df: DataFrame, mapCol: String = "details_map"): DataFrame = {
    df.withColumn("detail", explode_outer(map_entries(col(mapCol))))
      .select(
        col("timestamp"),
        col("user_id"),
        col("event_type"),
        col("detail.key").as("detail_key"),
        col("detail.value").as("detail_value")
      )
  }
}
