package com.ingtjxoqg.exercism.medium

object RunLengthEncoding {

  def encode(input: String): String = {
    if (input.isEmpty) return ""

    input
      .foldRight(List.empty[(Char, Int)]) { (c, acc) =>
        acc match {
          case (ch, n) :: tail if ch == c => (ch, n + 1) :: tail
          case _ => (c, 1) :: acc
        }
      }
      .map { case (ch, n) => if (n == 1) ch.toString else s"$n$ch" }
      .mkString
  }

  def decode(encoded: String): String = {
    encoded
      .foldLeft(("", "")) { case ((numStr, result), ch) =>
        if (ch.isDigit) (numStr + ch, result)
        else {
          val count = if (numStr.isEmpty) 1 else numStr.toInt
          ("", result + (ch.toString * count))
        }
      }._2
  }
}

