package com.ingtjxoqg.spark.comparator

import com.ingtjxoqg.spark.model.Product
import scala.io.Source

object CatalogComparator {

  /** Read catalog file and parse into Seq[Product] */
  def readCatalog(filePath: String): Seq[Product] = {
    val lines = Source.fromFile(filePath).getLines()
    lines.map { line =>
      val cols = line.split(",", 5).map(_.trim)
      Product(
        product_id = cols(0),
        name = cols(1),
        description = cols(2),
        price = cols(3),
        category = cols(4)
      )
    }.toSeq
  }

  /** Compare yesterday vs today catalogs */
  def compareCatalogs(yesterday: Seq[Product], today: Seq[Product]): Map[String, Seq[String]] = {

    val yesterdayMap = yesterday.map(p => p.product_id -> p).toMap
    val todayMap     = today.map(p => p.product_id -> p).toMap

    // Newly Added
    val newlyAdded = todayMap.keySet.diff(yesterdayMap.keySet).toSeq

    // Deleted
    val deleted = yesterdayMap.keySet.diff(todayMap.keySet).toSeq

    // Common IDs
    val commonIds = yesterdayMap.keySet.intersect(todayMap.keySet)

    // Updated vs Unchanged
    val (updated, unchanged) = commonIds.toSeq.partition { id =>
      yesterdayMap(id) != todayMap(id)
    }

    Map(
      "NewlyAdded" -> newlyAdded,
      "Updated"    -> updated,
      "Unchanged"  -> unchanged,
      "Deleted"    -> deleted
    )
  }
}