name := "project-euler"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "ch.qos.logback"              %   "logback-classic"   % "1.2.3",
  "com.typesafe.scala-logging"  %%  "scala-logging"     % "3.5.0",
  "com.typesafe.akka"           %%  "akka-stream"       % "2.5.6",
  "org.scalactic"               %%  "scalactic"         % "3.0.1" % "test",
  "com.typesafe.akka"           %%  "akka-testkit"      % "2.5.6" % "test",
  "org.scalatest"               %%  "scalatest"         % "3.0.1" % "test"
)