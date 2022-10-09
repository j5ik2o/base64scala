import sbt._

object Dependencies {
  object Versions {
    val scala211Version = "2.11.12"
    val scala212Version = "2.12.17"
    val scala213Version = "2.13.9"
    val scala3Version   = "3.2.0"

  }
  object scalatest {
    val scalatest = "org.scalatest" %% "scalatest" % "3.2.14"
  }
}
