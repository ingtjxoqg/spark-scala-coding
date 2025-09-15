package com.ingtjxoqg.exercism.medium

object Luhn {
  def valid(input: String): Boolean = {
    val digitsOnly = input.replaceAll("\\s", "")
    if (digitsOnly.length <= 1 || !digitsOnly.forall(_.isDigit)) return false
    val digits = digitsOnly.map(_.asDigit).toList.reverse
    val sum = digits.zipWithIndex.map { case (digit, idx) =>
      if (idx % 2 == 1) {
        val doubled = digit * 2
        if (doubled > 9) doubled - 9 else doubled
      } else digit
    }.sum
    sum % 10 == 0
  }
}