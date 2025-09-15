package com.ingtjxoqg.exercism.easy

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B]  =  {
    list.foldLeft(List.empty[B]) { (acc, elem) =>
      acc :+ f(elem)
    }
  }
}
