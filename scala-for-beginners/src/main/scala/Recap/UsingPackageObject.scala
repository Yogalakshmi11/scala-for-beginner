package Recap
import org.apache.spark.sql.{SparkSession => session}
object UsingPackageObject extends App{
  squareIt(3*3)

  // PACKAGES
  // 1. package name for each subclasses
  // -- package main.subclass1
  // -- package main.subclass2
  // 2. we can use the fields and methods
  // -- we can use the fields and methods by import it by using package name
  // 3. package object
  // -- one package object for each packages
  // -- we can have all the generics functions and methods here and we can use it all over the packages
  // 4. Alias for package name
  // -- by using =>
  // 5. import the package or else use the fully qualified name while using it
  // 6. default packages
  // -- java for string, exception
  // -- scala for int, nothing
  // -- predef for println
}
