package SparkTutorial


import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object dfBasics extends App{
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
//    .option("inferSchema", "true")
    .schema(schema)
    .load("/home/yogalakshmir/Documents/Learnings/scala/sparkTry.json")


  firstDf.show()

  firstDf.printSchema()
  firstDf.schema
  firstDf.take(2).foreach(println) // output would be in a array data type


  val myRow = ("Yoga", "23", "Chennai")
  // dataframe in scala are immutable, so we cannot add a row to the existing df, rather than we can
  // add the row to the seq of trail rows and create the new df

  val trailRows = Seq(
    ("Yoga", "23", "Chennai"),
    ("Yoga", "23", "Chennai"),
    ("Yoga", "23", "Chennai")
  )

  val manualDF = trySpark.createDataFrame(trailRows) // unable to give the column name
  manualDF.show()

  import trySpark.implicits._

  val manualDFWithImplicits = trailRows.toDF("Name", "Age", "City") // col name will be given

  manualDFWithImplicits.show()

  // Schema of the DataFrame
  val Aschema = StructType(Seq(
    StructField("name", StringType, nullable = true),
    StructField("age", IntegerType, nullable = true),
    StructField("city", StringType, nullable = true)
  ))
  val combinedRow = trailRows :+ myRow
  val manualCombinedDF = trySpark.createDataFrame(combinedRow)
  manualCombinedDF.show()

  val manualCombinedDfWithImplicits = combinedRow.toDF("Name", "Age", "City")
  // toDF is for Seq type
  manualCombinedDfWithImplicits.show()
  manualCombinedDfWithImplicits.schema
  manualCombinedDfWithImplicits.printSchema(
  )
  manualCombinedDfWithImplicits.take(2).foreach(println)
  println(manualCombinedDfWithImplicits.count())


  // the data types will be know when the data frame is used not at the compile times, simply like a lazy val, (call by name)doubt


  val jsonData : DataFrame = trySpark.read.schema(schema).json("/home/yogalakshmir/Documents/Learnings/scala/sparkTry.json")
//    println(jsonData.columns.mkString(", "))

  jsonData.show()
  trySpark.stop()


  // partioning in scala
  // the data will be split into files and then shared between the nodes in cluster
  // spark
  // lazy evaluation
  // planning
  // graph (want to do, including exchange of data, it will have a graph and do the work acc to the plan) + transformation(the actual task)
  // optimization
  // task to each and every nodes
  // tranfraation vs action
  // transformation -> math, operation
  // action -> show(), schema, printschema()
}
