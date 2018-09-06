package com.github.j5ik2o.base64scala

import java.nio.charset.Charset

trait Base64StringFactory {

  def charset: Charset

  def encode(bytes: Array[Byte]): Either[Base64EncodeError, Base64String]

  def encode(bigInt: BigInt): Either[Base64EncodeError, Base64String]

  def encode(string: String): Either[Base64EncodeError, Base64String]

}

object Base64StringFactory {

  def apply(urlSafe: Boolean = false, isNoPadding: Boolean = false): Base64StringFactory = new Default(urlSafe, isNoPadding)

  private[base64scala] class Default(urlSafe: Boolean, isNoPadding: Boolean) extends AbstractBase64StringFactory(urlSafe, isNoPadding) {
    override protected def createInstance(value: String): Base64String = new Base64String.Default(value, urlSafe, charset)
  }

}

