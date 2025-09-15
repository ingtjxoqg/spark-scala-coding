package com.ingtjxoqg.exercism.medium

object Anagram {

  def findAnagrams(target: String, candidates: Seq[String]): Seq[String] = {
    val normalizedTarget = normalize(target)

    candidates.filter { candidate =>
      val normalizedCandidate = normalize(candidate)
      !candidate.equalsIgnoreCase(target) &&
        normalizedCandidate == normalizedTarget
    }
  }

  private def normalize(word: String): String =
    word.toLowerCase.sorted
}

