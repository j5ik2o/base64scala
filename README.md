# base64scala

[![CI](https://github.com/j5ik2o/base64scala/workflows/CI/badge.svg)](https://github.com/j5ik2o/base64scala/actions?query=workflow%3ACI)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13)
[![Renovate](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Installation

Add the following to your sbt build (Scala 2.11.x, 2.12.x, 2.13.x, 3.0.x):

### Release Version

```scala
val version = "..."

libraryDependencies += "com.github.j5ik2o" %% "base64scala" % version
```

### Snapshot Version

```scala
resolvers += "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/snapshots/"

val version = "..."

libraryDependencies += "com.github.j5ik2o" %% "base64scala" % version
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
