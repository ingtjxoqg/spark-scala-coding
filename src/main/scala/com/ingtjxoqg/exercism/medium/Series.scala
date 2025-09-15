package com.ingtjxoqg.exercism.medium

object Series {
  def slices(n: Int, digits: String): List[List[Int]] = digits.map(_.asDigit).toList.sliding(n).toList
}