package com.github.j5ik2o.base64scala

import org.scalatest.EitherValues
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Base64StringSpec extends AnyFreeSpec with Matchers with EitherValues {
  "Base64String" - {
    "encode" in {
      val string       = "ABC"
      val base64String = Base64StringFactory().encode(string).right.value
      base64String.asString shouldBe "QUJD"
      base64String.decode.right.value shouldBe string.getBytes(base64String.charset)
      base64String.decodeToBigInt.right.value shouldBe BigInt(1, string.getBytes(base64String.charset))
      base64String.decodeToString.right.value shouldBe string

      val base64String2 = Base64String("QUJD")
      base64String2.asString shouldBe "QUJD"
      base64String2.decodeToString.right.value shouldBe string

    }
  }
}
