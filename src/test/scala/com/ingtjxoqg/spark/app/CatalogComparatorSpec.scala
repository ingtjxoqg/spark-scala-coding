package com.ingtjxoqg.spark.app

import com.ingtjxoqg.spark.comparator.CatalogComparator
import com.ingtjxoqg.spark.model.Product
import org.scalatest.funsuite.AnyFunSuite

class CatalogComparatorSpec extends AnyFunSuite {

  test("Compare yesterday and today catalogs") {
    val yesterday = CatalogComparator.readCatalog("src/test/resources/yesterday_catalog.txt")
    val today     = CatalogComparator.readCatalog("src/test/resources/today_catalog.txt")

    val result = CatalogComparator.compareCatalogs(yesterday, today)

    // Check all four categories
    assert(result("NewlyAdded").contains("104"))
    assert(result("Updated").contains("101"))
    assert(result("Unchanged").contains("103"))
    assert(result("Deleted").contains("102"))
  }

  test("Empty catalogs") {
    val result = CatalogComparator.compareCatalogs(Seq.empty, Seq.empty)

    assert(result("NewlyAdded").isEmpty)
    assert(result("Updated").isEmpty)
    assert(result("Unchanged").isEmpty)
    assert(result("Deleted").isEmpty)
  }

  test("All products updated") {
    val yesterday = Seq(
      Product("1", "A", "desc", "10", "cat"),
      Product("2", "B", "desc", "20", "cat")
    )
    val today = Seq(
      Product("1", "A", "desc updated", "10", "cat"),
      Product("2", "B", "desc updated", "20", "cat")
    )

    val result = CatalogComparator.compareCatalogs(yesterday, today)
    assert(result("Updated").toSet == Set("1", "2"))
    assert(result("Unchanged").isEmpty)
    assert(result("NewlyAdded").isEmpty)
    assert(result("Deleted").isEmpty)
  }
}