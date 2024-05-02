package SparkTutorial

import org.apache.spark.sql.types._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StructField, StructType}

object Recap extends App {
  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()

  // version 1 - Reading dataframe
  val readJson = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  //  readJson.show()

  // version 2 - Reading dataframe

  val readJsonV2 = spark.read
    .option("inferSchema", "true")
    .format("json")
    .load("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  //  readJsonV2.show()


  // version 1 - Schema
  // using inferSchema

  val schemaV1 = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")



  // version 2 - Schema
  // using Struct, StructField

  val schema = StructType(Seq(
    StructField("name", StringType, nullable = true),
    StructField("city", StringType, nullable = true),
    StructField("age", StringType, nullable = true)
  ))

  val schemaV2 = spark.read
    .schema(schema)
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  //  schemaV2.show()


  // note when we are using our own schema, the order of the dataframe will not change.

  // Now Handling date, datediff -> to get the age current date and dob, that difference will give us age.


  val dateSchema = StructType(Seq(
    StructField("name", StringType, nullable = true),
    StructField("city", StringType, nullable = true),
    StructField("age", IntegerType, nullable = true),
    StructField("date", StringType, nullable = true)
  ))
  val dateHandling = spark.read
    .schema(dateSchema)
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/date.json")

  //  dateHandling.select(to_date(col("date"),"dd-MMM-yy").as("actual_date")).show()

  // note : we cannot change the type of the date while reading itself by using the schema, instead we can create a new df
  // and by using the to-date function and by passing the current date format, we can get the standard date format.


  // Extracting columns in different ways - benchMark - 4

  import spark.implicits._

  dateHandling.select(
    dateHandling.col("date"),
    col("date"),
    column("date"),
    expr("date"),
    'date,
    $"name",
    expr("age * 0") // will do math operations here
  )
  //    .show()


  // select and selectExpr

  dateHandling.selectExpr(
    "age * 0",
    "upper(name) AS name"
  ).show()

  // create a column

  val newDf = dateHandling.withColumn("Capital Name", initcap(col("name")))
  newDf.select("`Capital Name`").show()

  // drop a column

  val drop = newDf.drop("Capital Name")
  //  drop.show()

  // take only two rows

  println(dateHandling.take(2).mkString(", "))


  // filtering

  dateHandling.filter(col("name") =!= "Bob").show()
  dateHandling.where(col("name") === "Bob").show()
  dateHandling.filter("name = 'Bob'").show()

  // multiple filtering
  val one = dateHandling.filter("name = 'Bob' and date = '09-APR-26'")
  dateHandling.filter(col("name") === "Bob" and col("date") === "09-APR-26").show()


  // aggregation

  dateHandling.union(one).show()
  dateHandling.distinct().show()
  dateHandling.intersect(one).show()

  dateHandling.select(avg(col("age"))).show()
  dateHandling.select(count(col("age"))).show()
  dateHandling.select(countDistinct(col("age"))).show()
  dateHandling.orderBy(desc("age")).limit(2).show()

  // groupBy

  dateHandling.groupBy(col("city")).agg(count(col("age"))).show()
  dateHandling.groupBy(col("city")).avg("age").show()

  // if we want to do one or more operations use agg
  dateHandling.groupBy(col("city")).agg(
    count(col("age")).as("count"),
    avg(col("age")).as("average")
  ).show()

  // read and write dataframes

  // readJson we already covered at the top

  // readCSV
  val readCSV = spark.read
    .options(Map(
      "header" -> "true",
      "sep" -> ",",
      "nullValue" -> "")
    )
    .csv("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/research-and-development-survey-2022-csv-notes.csv")

  readCSV.show()

  // write json
  readJson.write
    .mode(saveMode = "Overwrite")
    .format("json")
    .save("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/writeJson.json")



  // write csv
  readCSV.write
    .mode(saveMode = "Overwrite")
    .format("csv")
    .save("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/writeCSV.csv")

  // len of a df

  readCSV.select(count("*")).show() // includes null
  readCSV.select(count("Number")).show() // excludes null


  // create df manually
  val rows = Seq(
    ("temple", "place to worship"),
    ("school", "place to learn"),
    ("office", "place to think and work")
  )
  val manualDf = spark.createDataFrame(rows) // no headers
  val df = rows.toDF("Places", "Description")
  df.show()
}