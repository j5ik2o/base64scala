val scala211Version = "2.11.12"
val scala212Version = "2.12.11"
val scala213Version = "2.13.1"

val coreSettings = Seq(
  sonatypeProfileName := "com.github.j5ik2o",
  organization := "com.github.j5ik2o",
  scalaVersion := scala213Version,
  crossScalaVersions := Seq(scala211Version, scala212Version, scala213Version),
  scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:_",
      "-target:jvm-1.8"
    ),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := {
    <url>https://github.com/j5ik2o/base64scala</url>
      <licenses>
        <license>
          <name>The MIT License</name>
          <url>http://opensource.org/licenses/MIT</url>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:j5ik2o/base64scala.git</url>
        <connection>scm:git:github.com/j5ik2o/base64scala</connection>
        <developerConnection>scm:git:git@github.com:j5ik2o/base64scala.git</developerConnection>
      </scm>
      <developers>
        <developer>
          <id>j5ik2o</id>
          <name>Junichi Kato</name>
        </developer>
      </developers>
  },
  publishTo := sonatypePublishToBundle.value,
  credentials := {
    val ivyCredentials = (baseDirectory in LocalRootProject).value / ".credentials"
    val gpgCredentials = (baseDirectory in LocalRootProject).value / ".gpgCredentials"
    Credentials(ivyCredentials) :: Credentials(gpgCredentials) :: Nil
  },
  scalafmtOnCompile in ThisBuild := true
)

val circeVersion    = "0.13.0"
val akkaHttpVersion = "10.1.11"
val akkaVersion     = "2.6.4"

lazy val library = (project in file("library")).settings(
  coreSettings ++ Seq(
    name := "base64scala",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.1.1" % Test)
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
    name := "base64scala-project"
  )
  .aggregate(library, example)
