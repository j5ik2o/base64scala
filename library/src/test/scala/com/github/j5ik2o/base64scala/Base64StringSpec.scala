package com.github.j5ik2o.base64scala

import org.scalatest.{FreeSpec, Matchers}

class Base64StringSpec extends FreeSpec with Matchers {
  "Base64String" - {
    "encode" in {
      val string = "ABC"
      val base64String = Base64StringFactory().encode(string).right.get
      base64String.asString shouldBe "QUJD"
      base64String.decode.right.get shouldBe string.getBytes(base64String.charset)
      base64String.decodeToBigInt.right.get shouldBe BigInt(1, string.getBytes(base64String.charset))
      base64String.decodeToString.right.get shouldBe string

      val base64String2 = Base64String("QUJD")
      base64String2.asString shouldBe "QUJD"
      base64String2.decodeToString.right.get shouldBe string

    }
  }
}
