package com.ingtjxoqg.spark.app

import com.ingtjxoqg.spark.comparator.CatalogComparator

object CatalogComparatorMainApp {
  def main(args: Array[String]): Unit = {

    val yesterdayPath = "src/test/resources/yesterday_catalog.txt"
    val todayPath = "src/test/resources/today_catalog.txt"

    val yesterday = CatalogComparator.readCatalog(yesterdayPath)
    val today = CatalogComparator.readCatalog(todayPath)

    val result = CatalogComparator.compareCatalogs(yesterday, today)

    println("=== Newly Added ===")
    println(result("NewlyAdded").mkString(", "))
    println("=== Updated ===")
    println(result("Updated").mkString(", "))
    println("=== Unchanged ===")
    println(result("Unchanged").mkString(", "))
    println("=== Deleted ===")
    println(result("Deleted").mkString(", "))
  }
}