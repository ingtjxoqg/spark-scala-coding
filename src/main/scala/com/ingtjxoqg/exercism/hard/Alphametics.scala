package com.ingtjxoqg.exercism.hard

object Alphametics {
  type Solution = Map[Char, Int]

  def solve(puzzle: String): Option[Solution] = {
    val (lhsWords, rhsWord) = parsePuzzle(puzzle)
    val allWords = lhsWords :+ rhsWord

    val uniqueLetters = allWords.mkString.distinct.toList
    if (uniqueLetters.length > 10) return None

    val leadingLetters = allWords.filter(_.length > 1).map(_.head).toSet

    // Reverse words for column-wise processing
    val lhsCols = lhsWords.map(_.reverse)
    val rhsCol  = rhsWord.reverse

    def backtrack(col: Int, carry: Int, mapping: Map[Char, Int], used: Set[Int]): Option[Solution] = {
      if (col >= rhsCol.length && carry == 0) return Some(mapping)
      if (col >= rhsCol.length) return None

      val lhsLetters = lhsCols.flatMap(w => if (col < w.length) Some(w(col)) else None)
      val rhsLetter  = if (col < rhsCol.length) rhsCol(col) else ' '

      val allLetters = (lhsLetters :+ rhsLetter).filter(_ != ' ')
      val unassigned = allLetters.filterNot(mapping.contains).distinct

      def tryAssign(letters: List[Char], m: Map[Char, Int], u: Set[Int]): Option[Solution] = {
        letters match {
          case Nil =>
            val lhsSum = lhsLetters.map(m).sum + carry
            val rhsDigit = m(rhsLetter)
            if (lhsSum % 10 == rhsDigit)
              backtrack(col + 1, lhsSum / 10, m, u)
            else None

          case l :: tail =>
            (0 to 9).iterator
              .filterNot(u)
              .filterNot(d => d == 0 && leadingLetters.contains(l))
              .flatMap { d =>
                tryAssign(tail, m + (l -> d), u + d)
              }
              .take(1)
              .toList
              .headOption
        }
      }

      tryAssign(unassigned, mapping, used)
    }

    backtrack(0, 0, Map.empty, Set.empty)
  }

  private def parsePuzzle(puzzle: String): (List[String], String) = {
    val parts = puzzle.replaceAll(" ", "").split("==")
    val lhs = parts(0).split("\\+").toList
    val rhs = parts(1)
    (lhs, rhs)
  }
}
