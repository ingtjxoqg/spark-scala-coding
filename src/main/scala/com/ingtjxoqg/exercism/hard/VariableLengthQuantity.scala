package com.ingtjxoqg.exercism.hard

object VariableLengthQuantity {

  /** Encode a list of integers into a flat VLQ byte stream */
  def encode(numbers: List[Int]): List[Int] =
    numbers.flatMap(encodeSingle)

  /** Decode a flat VLQ byte stream into integers, or Left on incomplete sequence */
  def decode(bytes: List[Int]): Either[String, List[Int]] = {
    val out = collection.mutable.ListBuffer.empty[Int]
    var acc: Long = 0L
    var expectingMore = false

    bytes.foreach { b0 =>
      val b = b0 & 0xFF // ensure unsigned byte semantics
      acc = (acc << 7) | (b & 0x7F)

      if ((b & 0x80) == 0) {
        // end of this VLQ number
        out += (acc & 0xFFFFFFFFL).toInt
        acc = 0L
        expectingMore = false
      } else {
        // continuation byte
        expectingMore = true
      }
    }

    if (expectingMore) Left("incomplete sequence")
    else Right(out.toList)
  }

  /** Encode a single Int as unsigned 32-bit into VLQ bytes */
  private def encodeSingle(n: Int): List[Int] = {
    val unsigned = n & 0xFFFFFFFFL
    if (unsigned == 0L) return List(0)

    var num = unsigned
    val bytes = collection.mutable.ListBuffer.empty[Int]

    // Start with least-significant 7 bits (without MSB set)
    bytes.prepend((num & 0x7F).toInt)
    num = num >>> 7

    // Prepend higher-order 7-bit groups with continuation bit set
    while (num > 0) {
      bytes.prepend(((num & 0x7F) | 0x80).toInt)
      num = num >>> 7
    }

    bytes.toList
  }
}
