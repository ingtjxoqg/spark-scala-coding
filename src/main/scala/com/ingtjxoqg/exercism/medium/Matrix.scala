package com.ingtjxoqg.exercism.medium

class Matrix(input: String) {
  private val matrix = input.split('\n')     // Split into rows
    .map(_.split(' ').map(_.toInt).toVector) // Split each row by space and convert to Int
    .toVector                                // Convert entire matrix to Vector of Vectors

  // Return the i-th column
  def column(i: Int): Vector[Int] =
    matrix.map(_(i)) // Take i-th element from each row

  // Return the i-th row
  def row(i: Int): Vector[Int] =
    matrix(i) // Return the row vector
}

object Matrix {
  def apply(matrix: String): Matrix =
    new Matrix(matrix)
}
