import sbt._

object Dependencies {
  object Versions {
    val scala211Version = "2.11.12"
    val scala212Version = "2.12.16"
    val scala213Version = "2.13.5"
    val scala3Version   = "3.1.3"

  }
  object scalatest {
    val scalatest = "org.scalatest" %% "scalatest" % "3.2.9"
  }
}
