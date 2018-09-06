package com.github.j5ik2o.base64scala

object BigIntUtils {

  def toBytesUnsigned(bigInt: BigInt): Array[Byte] = {
    val bitLen   = ((bigInt.bitLength + 7) >> 3) << 3
    val bigBytes = bigInt.toByteArray

    if (((bigInt.bitLength % 8) != 0) && (((bigInt.bitLength / 8) + 1) == (bitLen / 8))) {
      bigBytes
    } else {
      val (startSrc, len) = if ((bigInt.bitLength % 8) == 0) {
        (1, bigBytes.length - 1)
      } else {
        (0, bigBytes.length)
      }
      val startDst     = bitLen / 8 - len
      val resizedBytes = Array.ofDim[Byte](bitLen / 8)
      System.arraycopy(bigBytes, startSrc, resizedBytes, startDst, len)
      resizedBytes
    }
  }

}
