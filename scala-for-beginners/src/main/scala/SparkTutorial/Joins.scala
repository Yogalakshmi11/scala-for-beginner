package SparkTutorial

import org.apache.spark.sql.SparkSession

object Joins extends App{
  val spark = SparkSession.builder()
    .appName("Spark Recap")
    .config("spark.master", "local")
    .master("local[*]")
    .getOrCreate()

  def readJson(filename:String) = spark.read
    .option("inferSchema","true")
    .json(s"/home/yogalakshmir/Documents/Learnings/scala/scala-for-beginners/src/main/resources/$filename.json")

  val employees = readJson("employees")
  val departments = readJson("departments")
  val salaries = readJson("salaries")

  val inner = employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "inner")

  employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "outer")
  .show()

  // inner -> intersect
  // outer -> union
  // left_outer -> everything in the inner join and everything in the left table
  // right_outer -> everything in the inner join and everything in the right table
  // left_semi -> what are all the rows in the left table that satisfied with the right table
  // left_anti -> what are all the rows in the left table that not satisfied with the right table
  employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "left_outer")
    .show()
  employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "right_outer")
    .show()

  employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "left_semi")
    .show()
  employees.join(departments, employees.col("dept_id") === departments.col("dept_id"), "left_anti")
    .show()

  // when we are doing joins with one column, the resulting dataframe will have duplicates of that column
  inner.select(departments.col("dept_id")).show()
//  employees.join(departments.withColumnRenamed("dept_id", "id"), "id")
//    .show() // not working

  // it is better to rename the column before joining
  // it ois better to rename the column before joining with othe rtable
}
