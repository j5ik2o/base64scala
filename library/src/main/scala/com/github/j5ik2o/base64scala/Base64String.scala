package com.github.j5ik2o.base64scala

import java.nio.charset.{ Charset, StandardCharsets }

trait Base64String {

  def length: Int
  def asString: String
  def rawBytes: Array[Byte]
  def charset: Charset

  def decode: Either[Base64DecodeError, Array[Byte]]

  def decodeToBigInt: Either[Base64DecodeError, BigInt]

  def decodeToString: Either[Base64DecodeError, String]

}

object Base64String {

  def apply(base64Value: String, urlSafe: Boolean = false, charset: Charset = StandardCharsets.UTF_8): Base64String =
    new Default(base64Value, urlSafe, charset)

  private[base64scala] class Default(base64Value: String, urlSafe: Boolean, charset: Charset)
      extends AbstractBase64String(base64Value, urlSafe, charset) {

    override def toString: String = s"Base64String($base64Value)"

    override def hashCode(): Int = 31 * base64Value.##

    def canEqual(other: Any): Boolean = other.isInstanceOf[Default]

    override def equals(obj: scala.Any): Boolean = obj match {
      case that: Default => that.canEqual(this) && asString == that.asString
      case _             => false
    }

  }

}
