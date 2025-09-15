package com.ingtjxoqg.exercism.medium

object MatchingBrackets {
  def isPaired(brackets: String): Boolean = {
    val stack = scala.collection.mutable.Stack[Char]()

    val bracketPairs: Map[Char, Char] = Map(
      ')' -> '(',
      '}' -> '{',
      ']' -> '['
    )

    for (ch <- brackets) {
      ch match {
        case '(' | '{' | '[' =>
          stack.push(ch)

        case ')' | '}' | ']' =>
          if (stack.isEmpty || stack.pop() != bracketPairs(ch)) {
            return false
          }

        case _ =>
      }
    }

    stack.isEmpty
  }
}
