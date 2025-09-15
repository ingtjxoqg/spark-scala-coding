package com.ingtjxoqg.exercism.medium

object PigLatin {

  def translate(sentence: String): String =
    sentence.split("\\s+").map(translateWord).mkString(" ")

  private def translateWord(word: String): String = {
    // Regex patterns for each rule
    val vowelOrSpecial = "(?i)^(?:[aeiou]|xr|yt).*".r
    val consonantQu = "(?i)^([^aeiou]*qu)(.*)".r
    val consonantY = "(?i)^([^aeiou]+)(y.*)".r
    val consonant = "(?i)^([^aeiou]+)(.*)".r

    word match {
      case vowelOrSpecial()       => word + "ay"                // Rule 1
      case consonantQu(prefix, rest) => rest + prefix + "ay"   // Rule 3
      case consonantY(prefix, rest)  => rest + prefix + "ay"   // Rule 4
      case consonant(prefix, rest)   => rest + prefix + "ay"   // Rule 2
      case _                          => word + "ay"            // fallback
    }
  }
}
