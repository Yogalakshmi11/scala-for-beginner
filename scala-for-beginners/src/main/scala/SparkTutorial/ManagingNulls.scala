package SparkTutorial

import SparkTutorial.Recap.{schema, spark}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{coalesce, col}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object ManagingNulls extends App{
  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()

  val schema = StructType(Seq(
    StructField("name", StringType, nullable = true),
    StructField("city", StringType, nullable = true),
    StructField("age", StringType, nullable = true)
  ))

  // nullable = true, means df can contains null values, nullable = false means df cannot contain null values
  val schemaV2 = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/null.json")

  schemaV2.select(col("name"),
    coalesce(col("age"), col("alter_age"))
  ).show()

  schemaV2.select(col("age")).where(col("age").isNull).show()
  schemaV2.select(col("age")).orderBy(col("age").desc_nulls_last).show() // it will give only the age column as the sorted output
  schemaV2.orderBy(col("age").desc_nulls_last).show() // it will give the whole table with sorted age as the output


  // remove nulls
  schemaV2.select(col("age")).na.drop().show()
  // replace nulls -> should replace with the same dataType
  schemaV2.na.fill(0, List("age", "alter_age")).show()

  schemaV2.na.fill(Map(
    "age" -> 0,
    "alter_age" -> 1
  )).show()

  // coalesce in expression

  schemaV2.selectExpr(
    "ifnull(age, alter_age)", // same like coalesce
    "nvl(age, alter_age)", // same like coalesce
    "nullif(age, alter_age)", // if both the values are same, then return null
    "nvl2(age, alter_age, 0)" // if(age) return alter_age else 0
  ).show()

}
