lazy val commonSettings = Seq(
  organization := "io.bitmagic",
  version := "0.0.1",
  // set the Scala version used for the project
  scalaVersion := "2.12.3"
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1"
)


lazy val root = (project in file("."))
  .settings(
    commonSettings,
    // set the name of the project
    name := "BitMagicJ"
  )

