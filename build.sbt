name := """korean-test"""
organization := "com.goshorn"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += jdbc
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.7"
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.goshorn.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.goshorn.binders._"
