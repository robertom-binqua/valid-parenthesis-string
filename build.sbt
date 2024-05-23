import Dependencies._

ThisBuild / scalaVersion     := "2.13.14"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "valid-parenthesis-string",
    libraryDependencies += munit % Test
  )

