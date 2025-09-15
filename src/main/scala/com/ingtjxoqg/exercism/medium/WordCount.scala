package com.ingtjxoqg.exercism.medium

case class WordCount(phrase: String) {
  def countWords: Map[String, Int] = {
    // Regex explanation:
    // [a-z0-9]+(?:'[a-z0-9]+)?
    //   → matches words with optional apostrophes inside (e.g. "don't", "it's")
    // [a-z0-9]+
    //   → matches regular words (letters or numbers)
    val wordRegex = """[a-z0-9]+(?:'[a-z0-9]+)?""".r

    wordRegex
      .findAllIn(phrase.toLowerCase) // find all words
      .foldLeft(Map.empty[String, Int]) { (acc, word) =>
        acc.updated(word, acc.getOrElse(word, 0) + 1) // increment counts
      }
  }
}
