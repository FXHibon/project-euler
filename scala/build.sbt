name := "project-euler"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "ch.qos.logback"              %   "logback-classic"   % "1.2.3",
  "com.typesafe.scala-logging"  %%  "scala-logging"     % "3.9.2",
  "com.typesafe.akka"           %%  "akka-stream"       % "2.6.0",
  "org.scalactic"               %%  "scalactic"         % "3.0.8" % Test,
  "org.scalatest"               %%  "scalatest"         % "3.0.8" % Test
)
