package SparkTutorial

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object CommonTypes extends App{
  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()

  // version 1 - Reading dataframe
  val readJson = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  // adding plain value to DF
  readJson.select(col("name"), lit(54).as("plain_value_column")).show()

  // Booleans
  val cityFilter = col("city") === "New York"
  val ageFilter = col("age") < 35
  val preferredFilter = cityFilter and ageFilter
  val booleanTable = readJson.select(col("name"), preferredFilter.as("Boolean_column"))
  booleanTable.where(not(col("Boolean_column"))).show()


  // string
  readJson.select("*").where(col("name").contains("Bob")).show()

  // regex
  val regexPattern = "Bob|Nnao"
  readJson.select(col("name"), regexp_extract(col("name"), regexPattern,0)).show()
  readJson.select(col("name"), regexp_replace(col("name"), regexPattern, "try")).show()


  // structures - by using struct we will get the struct

  readJson.select(col("name"), struct(col("city"), col("age"))).show()

  readJson.selectExpr("name", "(city, age)").show()

  // for array -> we have split, size, array_contains in array

}
