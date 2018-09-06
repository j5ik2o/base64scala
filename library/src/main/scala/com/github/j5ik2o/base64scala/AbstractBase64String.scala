package com.github.j5ik2o.base64scala

import java.nio.charset.Charset
import java.util.Base64.Decoder

abstract class AbstractBase64String(val base64Value: String, val urlSafe: Boolean, val charset: Charset)
    extends Base64String {

  override val length: Int = base64Value.length

  override val asString: String = base64Value

  protected lazy val decoder: Decoder = {
    if (urlSafe)
      java.util.Base64.getUrlDecoder
    else
      java.util.Base64.getDecoder
  }

  override lazy val rawBytes: Array[Byte] = base64Value.getBytes(charset)

  override lazy val decode: Either[Base64DecodeError, Array[Byte]] = {
    try {
      Right(decoder.decode(base64Value.getBytes(charset)))
    } catch {
      case ex: Exception =>
        Left(Base64DecodeError(ex.getMessage))
    }
  }

  override lazy val decodeToBigInt: Either[Base64DecodeError, BigInt] = decode.map(BigInt(1, _))

  override lazy val decodeToString: Either[Base64DecodeError, String] =
    decode.map(new String(_, charset))

}
