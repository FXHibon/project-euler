name := "project-euler"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "ch.qos.logback"              %   "logback-classic"   % "1.2.3",
  "com.typesafe.scala-logging"  %%  "scala-logging"     % "3.9.0",
  "com.typesafe.akka"           %%  "akka-stream"       % "2.5.14",
  "org.scalactic"               %%  "scalactic"         % "3.0.5" % Test,
  "org.scalatest"               %%  "scalatest"         % "3.0.5" % Test
)
