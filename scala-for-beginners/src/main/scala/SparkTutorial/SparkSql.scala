package SparkTutorial

import org.apache.spark.sql.SparkSession

object SparkSql extends App{

  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .config("spark.sql.warehouse.dir", "src/main/resources/warehouse")
    .master("local[*]")
    .getOrCreate()

  // version 1 - Reading dataframe
  val readJson = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")


  readJson.createTempView("cars")
  val carSql = spark.sql(
    "select city from cars where name = 'Bob'"
  )
  carSql.show()

  spark.sql("create database school")
  spark.sql("use school")
  spark.sql("show databases")

  // transformation tables from a database to spark tables

//  spark.read.table("employees")
}
