val coreSettings = Seq(
  sonatypeProfileName := "com.github.j5ik2o",
  organization := "com.github.j5ik2o",
  scalaVersion := "2.12.6",
  crossScalaVersions := Seq("2.11.11", "2.12.6"),
  scalacOptions ++= {
    Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:existentials",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-language:higherKinds"
    ) ++ {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2L, scalaMajor)) if scalaMajor == 12 =>
          Seq.empty
        case Some((2L, scalaMajor)) if scalaMajor <= 11 =>
          Seq(
            "-Yinline-warnings"
          )
      }
    }
  },
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ =>
    false
  },
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
  publishTo in ThisBuild := sonatypePublishTo.value,
  credentials := {
    val ivyCredentials = (baseDirectory in LocalRootProject).value / ".credentials"
    Credentials(ivyCredentials) :: Nil
  },
  scalafmtOnCompile in ThisBuild := true,
  scalafmtTestOnCompile in ThisBuild := true
)

val circeVersion    = "0.10.0-M1"
val akkaHttpVersion = "10.1.1"
val akkaVersion     = "2.5.11"

lazy val library = (project in file("library")).settings(
  coreSettings ++ Seq(
    name := "base64scala",
    libraryDependencies ++= Seq(
      "org.scalatest"  %% "scalatest"      % "3.0.5" % Test,
      "org.typelevel"  %% "cats-core"      % "1.1.0",
      "com.beachape"   %% "enumeratum"     % "1.5.13",
      "org.slf4j"      % "slf4j-api"       % "1.7.25",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % Test
    ) ++ Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-generic-extras",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
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
