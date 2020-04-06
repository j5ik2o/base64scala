# base64scala

[![CircleCI](https://circleci.com/gh/j5ik2o/base64scala/tree/master.svg?style=shield&circle-token=xxx)](https://circleci.com/gh/j5ik2o/base64scala/tree/master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.j5ik2o/base64scala_2.13)
[![Scaladoc](http://javadoc-badge.appspot.com/com.github.j5ik2o/base64scala_2.13.svg?label=scaladoc)](http://javadoc-badge.appspot.com/com.github.j5ik2o/base64scala_2.13/com/github/j5ik2o/base64scala/index.html?javadocio=true)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Installation

Add the following to your sbt build (Scala 2.11.x, 2.12.x,2.13.x):

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
