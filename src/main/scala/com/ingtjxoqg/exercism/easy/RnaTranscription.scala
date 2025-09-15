package com.ingtjxoqg.exercism.easy

object RnaTranscription {

  private val dnaToRna: Map[Char, Char] = Map(
    'G' -> 'C',
    'C' -> 'G',
    'T' -> 'A',
    'A' -> 'U'
  )

  def toRna(dna: String): Option[String] = {
    val maybeRna = dna.map { nucleotide =>
      dnaToRna.get(nucleotide)
    }

    if (maybeRna.forall(_.isDefined))
      Some(maybeRna.flatten.mkString)
    else
      None
  }
}

