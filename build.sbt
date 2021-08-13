import Dependencies._
import Dependencies.Versions._

val coreSettings = Seq(
  organization := "com.github.j5ik2o",
  homepage     := Some(url("https://github.com/j5ik2o/base64scala")),
  licenses     := List("The MIT License" -> url("http://opensource.org/licenses/MIT")),
  developers := List(
    Developer(
      id = "j5ik2o",
      name = "Junichi Kato",
      email = "j5ik2o@gmail.com",
      url = url("https://blog.j5ik2o.me")
    )
  ),
  scalaVersion       := scala213Version,
  crossScalaVersions := Seq(scala211Version, scala212Version, scala213Version, scala3Version),
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-encoding",
    "UTF-8",
    "-language:_",
    "-target:jvm-1.8",
    "-Yrangepos",
    "-Ywarn-unused"
  ),
  Test / publishArtifact := false,
  Test / fork            := true,
  Compile / doc / sources := {
    val old = (Compile / doc / sources).value
    if (scalaVersion.value == scala3Version) {
      Nil
    } else {
      old
    }
  },
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
  // Remove me when scalafix is stable and feature-complete on Scala 3
  ThisBuild / scalafixScalaBinaryVersion := (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) => CrossVersion.binaryScalaVersion(scalaVersion.value)
    case _            => CrossVersion.binaryScalaVersion(scala212Version)
  })
)

lazy val library = (project in file("library")).settings(
  coreSettings ++ Seq(
    name                                      := "base64scala",
    libraryDependencies += scalatest.scalatest % Test
  )
)

lazy val example = (project in file("example")).settings(
  coreSettings ++ Seq(
    name := "base64scala-example"
  )
) dependsOn library

lazy val `root` = (project in file("."))
  .settings(coreSettings)
  .settings(
    name := "base64scala-root"
  )
  .aggregate(library, example)

// --- Custom commands
addCommandAlias("lint", ";scalafmtCheck;test:scalafmtCheck;scalafmtSbtCheck;scalafixAll --check")
addCommandAlias("fmt", ";scalafmtAll;scalafmtSbt;scalafix RemoveUnused")
