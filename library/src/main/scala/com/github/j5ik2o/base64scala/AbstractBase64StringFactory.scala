package com.github.j5ik2o.base64scala

import java.nio.charset.{Charset, StandardCharsets}
import java.util.Base64.Encoder

abstract class AbstractBase64StringFactory(urlSafe: Boolean, isNoPadding: Boolean) extends Base64StringFactory {

  protected lazy val encoder: Encoder = {
    if (urlSafe) {
      val encoder = java.util.Base64.getUrlEncoder
      if (isNoPadding)
        encoder.withoutPadding()
      else
        encoder
    } else {
      val encoder = java.util.Base64.getEncoder
      if (isNoPadding)
        encoder.withoutPadding()
      else
        encoder
    }
  }

  val charset: Charset = StandardCharsets.UTF_8

  protected def createInstance(param: String): Base64String

  override def encode(bytes: Array[Byte]): Either[Base64EncodeError, Base64String] =
    try {
      Right(createInstance(encoder.encodeToString(bytes)))
    } catch {
      case ex: Exception =>
        Left(Base64EncodeError(ex.getMessage))
    }

  override def encode(bigInt: BigInt): Either[Base64EncodeError, Base64String] =
    encode(BigIntUtils.toBytesUnsigned(bigInt))

  override def encode(string: String): Either[Base64EncodeError, Base64String] = encode(string.getBytes(charset))

}
