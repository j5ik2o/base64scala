package com.github.j5ik2o.base64scala

trait Base64Error {
  val message: String
  val cause: Option[Base64Error]
}

case class Base64DecodeError(message: String, cause: Option[Base64Error] = None) extends Base64Error

case class Base64EncodeError(message: String, cause: Option[Base64Error] = None) extends Base64Error
