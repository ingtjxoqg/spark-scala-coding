package com.ingtjxoqg.algorithm

import scala.io.StdIn

object MergeSortApp {

  /**
   * Performs merge sort on a list of integers.
   *
   * Logic:
   * 1. Base case → if the list has 0 or 1 elements, it is already sorted.
   * 2. Recursive case:
   *    - Split the list into two halves.
   *    - Recursively sort each half.
   *    - Merge the two sorted halves into one sorted list.
   */
  def mergeSort(xs: List[Int]): List[Int] = {
    if (xs.length <= 1) xs
    else {
      val mid = xs.length / 2
      val (left, right) = xs.splitAt(mid)

      val sortedLeft = mergeSort(left)
      val sortedRight = mergeSort(right)

      merge(sortedLeft, sortedRight)
    }
  }

  /**
   * Merge two sorted lists into one sorted list.
   * - Compare the heads of each list.
   * - Add the smaller element to the result.
   * - Continue recursively until one list is empty.
   */
  private def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
    case (Nil, r) => r
    case (l, Nil) => l
    case (lh :: lt, rh :: rt) =>
      if (lh <= rh) lh :: merge(lt, right)
      else rh :: merge(left, rt)
  }

  def main(args: Array[String]): Unit = {
    println("Enter integers separated by spaces:")
    val input = StdIn.readLine()

    try {
      val numbers = input.split("\\s+").toList.map(_.toInt)
      val sorted = mergeSort(numbers)
      println(s"Sorted result: ${sorted.mkString(" ")}")
    } catch {
      case _: NumberFormatException =>
        println("Invalid input. Please enter only integers separated by spaces.")
    }
  }
}
