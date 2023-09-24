import Dependencies.{ scalatest, Versions }

ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

def crossScalacOptions(scalaVersion: String): Seq[String] =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((3L, _)) =>
      Seq(
        "-source:3.0-migration",
        "-Xignore-scala2-macros"
      )
    case Some((2L, scalaMajor)) if scalaMajor >= 12 =>
      Seq(
        "-Ydelambdafy:method",
        "-target:jvm-1.8",
        "-Yrangepos",
        "-Ywarn-unused"
      )
  }

lazy val coreSettings = Seq(
  organization := "com.github.j5ik2o",
  homepage := Some(url("https://github.com/j5ik2o/base64scala")),
  licenses := List("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      id = "j5ik2o",
      name = "Junichi Kato",
      email = "j5ik2o@gmail.com",
      url = url("https://blog.j5ik2o.me")
    )
  ),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/j5ik2o/base64scala"),
      "scm:git@github.com:j5ik2o/base64scala.git"
    )
  ),
  scalaVersion := Versions.scala213Version,
  crossScalaVersions := Seq(
    Versions.scala212Version,
    Versions.scala213Version,
    Versions.scala3Version
  ),
  scalacOptions ++= (
    Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:_"
    ) ++ crossScalacOptions(scalaVersion.value)
  ),
  resolvers ++= Resolver.sonatypeOssRepos("staging"),
  resolvers ++= Resolver.sonatypeOssRepos("releases"),
  resolvers += "Seasar Repository" at "https://maven.seasar.org/maven2/",
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
  Test / publishArtifact := false,
  Test / fork := true,
  Test / parallelExecution := false,
  Compile / doc / sources := {
    val old = (Compile / doc / sources).value
    if (scalaVersion.value == Versions.scala3Version) {
      Nil
    } else {
      old
    }
  }
)

def versionFromFile: String = {
  var source: scala.io.Source = null
  try {
    source = scala.io.Source.fromFile("version")
    val version = source.mkString.trim
    println(s"version = $version")
    version
  } finally {
    if (source != null)
      source.close()
  }
}

ThisBuild / version := versionFromFile

lazy val library = (project in file("library")).settings(
  coreSettings ++ Seq(
    name := "base64scala",
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
