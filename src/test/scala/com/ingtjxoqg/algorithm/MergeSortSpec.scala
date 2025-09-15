package com.ingtjxoqg.algorithm

import org.scalatest.funsuite.AnyFunSuite

class MergeSortSpec extends AnyFunSuite {

  test("Empty list should remain empty") {
    assert(MergeSortApp.mergeSort(List()) == List())
  }

  test("Single element list should remain unchanged") {
    assert(MergeSortApp.mergeSort(List(5)) == List(5))
  }

  test("Already sorted list remains sorted") {
    assert(MergeSortApp.mergeSort(List(1, 2, 3, 4)) == List(1, 2, 3, 4))
  }

  test("Unsorted list should be sorted") {
    assert(MergeSortApp.mergeSort(List(4, 1, 3, 2)) == List(1, 2, 3, 4))
  }

  test("List with duplicate elements should sort correctly") {
    assert(MergeSortApp.mergeSort(List(3, 1, 2, 3, 1)) == List(1, 1, 2, 3, 3))
  }

  test("Large list should sort correctly") {
    val input = (1000 to 1 by -1).toList
    val sorted = MergeSortApp.mergeSort(input)
    assert(sorted == (1 to 1000).toList)
  }
}
