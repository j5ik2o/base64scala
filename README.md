# base64scala

[![CI](https://github.com/j5ik2o/base64scala/workflows/CI/badge.svg)](https://github.com/j5ik2o/base64scala/actions?query=workflow%3ACI)
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)
[![Mergify Status](https://img.shields.io/endpoint.svg?url=https://gh.mergify.io/badges/j5ik2o/base64scala&style=flat)](https://mergify.io)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13)
[![Scaladoc](http://javadoc-badge.appspot.com/com.github.j5ik2o/base64scala_2.13.svg?label=scaladoc)](http://javadoc-badge.appspot.com/com.github.j5ik2o/base64scala_2.13/com/github/j5ik2o/base64scala/index.html?javadocio=true)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Installation

Add the following to your sbt build (Scala 2.11.x, 2.12.x, 2.13.x):

### Release Version

```scala
resolvers += "Sonatype OSS Release Repository" at "https://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "com.github.j5ik2o" %% "base64scala" % "1.0.4"
```

### Snapshot Version

```scala
resolvers += "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "com.github.j5ik2o" %% "base64scala" % "1.0.5-SNAPSHOT"
```

## Usage

- Encode

```scala
val string = "ABC"
val base64Value: Base64String = Base64StringFactory().encode(string)
```

- Decode

```scala
val original = base64Value.decode // ABC
```
