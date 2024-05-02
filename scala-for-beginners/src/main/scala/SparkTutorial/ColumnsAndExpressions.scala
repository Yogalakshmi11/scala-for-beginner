package SparkTutorial

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

import scala.language.postfixOps

object ColumnsAndExpressions extends App{
  val spark = SparkSession.builder()
    .appName("DataFrames")
    .config("spark.master", "local")
    .getOrCreate()

  val readJson = spark.read
    .format("json")
    .option("inferSchema", "true")
    .load("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

//  readJson.show()
  // how to create columns - result column object
  val firstColumn = readJson.col("name")
  // selecting(projecting)



  val recordNameDf = readJson.select(firstColumn)
//  recordNameDf.show() // created the new dataframe from the obtaining the column from the existing dataframe, since df are immutable

  val recordNameInUpper = upper(readJson.col("name"))

  val newDf = readJson.select(
    readJson.col("name"),
    recordNameInUpper.as("Name_In_Upper"),
    upper(expr("city")).as("City_in_upper"),
    expr("age * 10").as("age_multiples_of_10")
  )
//  newDf.show()

  val newDFFromExpr = readJson.selectExpr(
    "name",
    "age * 0 AS 0_age",
    "upper(name) AS name_in_upper_case"

  )

  val newDFWithColumns = newDFFromExpr.withColumn("lower case name", lower(col("name")))
  val try1 = newDFWithColumns.selectExpr("`lower case name`")



  val aRemoveTry = newDFWithColumns.drop("`lower case name`", "Displacement")
  aRemoveTry.show()


  try1.show()


  // filtering

  val aFilteredDf = readJson.filter(col("city") =!= "Chicago")
  aFilteredDf.show()

  val aFilteredDfUsingWhere = readJson.where(col("city") =!= "Chicago")
  // for equal to ===
  // can do filter as many as we can
    // filtering using expression string

  val aFilterStrExpr = readJson.filter("city = 'Chicago'")

  val manyFilter = readJson.filter((col("city") =!= "Chicago" and col("name") === "Bob"))
  val manyFilterWithStrExpr = readJson.filter("city = 'Chicago' and name = 'Bob'")
  // add rows to the existing df
    val unionDf = readJson.union(aFilterStrExpr)
  unionDf.show()

  // distinct values
   val distinctDF = unionDf.distinct()
  distinctDF.show()

  val groupByDf = readJson.groupBy(col("age")).count()
  groupByDf.show()
  readJson.select(sum(col("age"))).show()
  readJson.select(count(col("age"))).show()
  readJson.select(mean(col("age"))).show()
  readJson.select(stddev(col("age"))).show()
  readJson.groupBy(col("city"))
    .avg("age").show()
  readJson.groupBy(col("city"))
    .agg(
      count(col("age")).as("Count of Age"),
      avg("age").as("Avg of Age")
    ).orderBy("`Avg of Age`") // sorting
    .show()

  readJson.select(countDistinct(col("age"))).show()
  readJson.select(approx_count_distinct(col("age"))).show()
}








































































































































































































































































