package com.ingtjxoqg.exercism.easy

object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    if (factors.isEmpty || limit <= 0) 0
    else {
      factors
        .filter(_ > 0)
        .flatMap { base =>
          (1 until limit).filter(_ % base == 0)
        }
        .sum
    }
  }
}

