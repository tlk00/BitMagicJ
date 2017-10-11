lazy val commonSettings = Seq(
  organization := "io.bitmagic",
  scalaVersion := "2.12.3"
)

lazy val configLib = "com.typesafe" % "config" % "1.3.1"
lazy val junitLib = "junit" % "junit" % "4.12" % "test"

lazy val bmjava = (project in file("bmjava"))
  .dependsOn(bmcore)
  .settings(
    commonSettings,
    libraryDependencies += junitLib,
    version := "0.0.1"
  )

lazy val bmscala = (project in file("bmscala"))
  .dependsOn(bmcore)
  .settings(
    commonSettings,
    version := "0.0.1"
  )

lazy val bmcore = (project in file("."))
  .settings(
    commonSettings
  )

