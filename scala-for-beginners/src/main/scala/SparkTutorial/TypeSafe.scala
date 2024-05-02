package SparkTutorial

import org.apache.spark.sql.functions.{avg, col}
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession}

object TypeSafe extends App {

  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()

  // version 1 - Reading dataframe
  val readJson = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  def readDF(filename : String) = spark.read
    .option("inferSchema", "true")
    .json(s"/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/${filename}")


  import spark.implicits._

  case class Car(
                  name: String,
                  age: BigInt,
                  city: String
                )

  val carDF = spark.read
    .option("inferSchema", "true")
    .json("/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/sparkTry.json")

  val carDS = carDF.as[Car]

  println(carDS.filter(car => car.name == "Bob").show())
  println(carDS.map(car => (car.name).toLowerCase).show())
  println(carDS.map(_.age.toInt).reduce(_ + _))

  carDS.select(avg(col("age"))).show()

  // steps to convert dataframe to dataset
  // step 1 : define the case class
  // step 2 : read the dataframe from the file
  // step 3 : define an encoder (importing the implicits)
  // step 4 : convert df to ds using as

  // another way to convert df to ds
  // using encoder.product(Car)

  val productEncoder: Encoder[Car] = Encoders.product[Car]
  val carDS1: Dataset[Car] = carDF.as(productEncoder)
  println(carDS1.map(_.age.toInt).reduce(_ + _) / carDS1.count())


  // joins in DS

  case class Employee (emp_id: BigInt,
                       emp_name: String,
                       dept_id: BigInt)

  case class Department (dept_id: BigInt,
                         dept_name: String,
                       )
  val employee = readDF("employees.json").as[Employee]
  val department = readDF("departments.json").as[Department]

  val emp_dept = employee.joinWith(department, employee.col("dept_id") === department.col("dept_id"), "inner").withColumnRenamed("_1", "employee").withColumnRenamed("_2", "department")
  emp_dept.show()
  employee.joinWith(department, employee.col("dept_id") === department.col("dept_id"), "inner").select('_1.as("emp"), '_2.as("dept")).show()


  // grouping
  carDS.groupByKey(_.city).count().show()
  // joins and groups are wide transformation -> shuffle operation
}