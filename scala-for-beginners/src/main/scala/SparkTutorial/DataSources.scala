package SparkTutorial


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object DataSources extends App{
  /*
  * Format - define the format
  * schema or inferSchema = true
  * zero or more options
  * */
  val trySpark = SparkSession.builder()
    .appName("DelveDive")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()
  val schema = StructType(Seq(
    StructField("name", StringType, nullable = true),
    StructField("age", IntegerType, nullable = true),
    StructField("city", StringType, nullable = true)
  ))

  val firstDf = trySpark.read
    .format("json")
    .option("mode", "failFast") // any error in the json file, it will throw the error. // drop malformed
    .schema(schema)
    .load("/home/yogalakshmir/Documents/Learnings/scala/sparkTry.json")

  firstDf.show()
  // if any error occurs, then the df will be empty, if we configured failFast, then it will throw an error

  val scondDf = trySpark.read
    .format("json")
    .options(Map(
      "mode" -> "failFast",
      "inferSchema" -> "true",
      "path" -> "/home/yogalakshmir/Documents/Learnings/scala/sparkTry.json"
    ))
    .load()

  scondDf.show()


  scondDf.write
    .format("json")
    .mode(saveMode = "Overwrite")
    .save("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/tryJson.json")




  firstDf.write
    .mode(saveMode = "Overwrite")
    .save("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/tryParquet.parquet")
  // default is parquet type, we don't want to mention the format


  firstDf.write
    .format("csv")
    .mode(saveMode = "Overwrite")
    .option("sep", "\t")
    .option("header", "true")
    .save("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/jsonToTsv.csv")


  val csvSchema = StructType(Seq(
    StructField("Number", IntegerType),
    StructField("Footnote", StringType))
  )
  val readCSV = trySpark.read
    .schema(csvSchema)
    .option("sep", ",")
    .option("header", "true")
    .option("nullValue", "")
    .csv("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/research-and-development-survey-2022-csv-notes.csv")

  readCSV.show()
  // pending postgresql

}


