lazy val commonSettings = Seq(
  organization := "io.bitmagic",
  scalaVersion := "2.12.3"
)

lazy val configLib = "com.typesafe" % "config" % "1.3.1"
lazy val junitLib = "junit" % "junit" % "4.12" % "test"
lazy val scalaTestLib = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val bmjava = (project in file("bmjava"))
  .dependsOn(bmcore)
  .settings(
    commonSettings,
    version := "0.0.1",
    libraryDependencies ++= Seq(junitLib, scalaTestLib),
    //logLevel := Level.Debug,
    unmanagedResourceDirectories in Compile += baseDirectory.value / ".." /  "native"
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

