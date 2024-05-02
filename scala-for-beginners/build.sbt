ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "scala-for-beginners"
  )
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.0" // Spark Core

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.0" // Spark SQL

libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.2.0" // Spark MLlib (optional, if needed)