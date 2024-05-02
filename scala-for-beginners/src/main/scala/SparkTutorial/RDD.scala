package SparkTutorial

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, col, count, size}

import scala.math.Ordered.orderingToOrdered

object RDD extends  App{
  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .config("spark.sql.warehouse.dir", "src/main/resources/warehouse")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext

  val stocksDF = spark.read
    .format("csv")
    .options(Map(
      "header" -> "true",
      "sep" -> ",",
      "path" -> "/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/research-and-development-survey-2022-csv-notes.csv"
    ))
    .load()

  stocksDF.show()

  case class stocks(
                   Number : Option[String],
                   Footnote : String
                   )

  import spark.implicits._

  val stocksDS = stocksDF.as[stocks]

  val stockRDD = stocksDS.rdd

  val greaterThanTen = stockRDD.map(_.Number.getOrElse("0")).filter(_.toInt>10) // lazy
  val greaterThanTenCount = greaterThanTen.count() // eager action

  println(greaterThanTenCount)

  implicit val orderingStock : Ordering[stocks] = Ordering.fromLessThan[stocks]((sa, sb) => sa.Number < sb.Number)
  val mini = stockRDD.min()
  println(mini)
  println(stockRDD)

  println(stockRDD.groupBy(_.Number)) // very expensive

//  stockRDD.repartition(30).toDF.write.mode(saveMode = "Overwrite").parquet("\"src/main/resources/partition.parquet")


  // Best practice of Partitioning is
  // size of a partition 10 - 100 MB

  val moviesDF = spark.read
    .option("inferSchema", "true")
    .json("src/main/resources/sparkTry.json")

  case class movies (
                    name : String,
                    age : Long,
                    city : String
                    )
  import spark.implicits._
  val moviesDS = moviesDF.as[movies]

  val moviesRDD = moviesDS.rdd

  val distinctCity = moviesRDD.map(_.city).distinct()
  println(distinctCity)

  // select all the names in chicago city where the age of the person is greater than 30

  moviesDF.select(col("city"),col("age"), col("name")).where(col("city") === "Chicago" and col("age") > 30).show()
  moviesRDD.filter(movies => movies.city == "Chicago" && movies.age > 30).map(_.name).toDF.show()
  println(moviesRDD.filter(movies => movies.city == "Chicago").map(_.age).reduce(_+_))

  case class CityAge (
                     city : String,
                     movie : Long
                     )
  moviesRDD.groupBy(_.city).map{
    case (city, movies) => CityAge(city, movies.map(_.age).sum/ movies.size)
  }.toDF().show()
}
