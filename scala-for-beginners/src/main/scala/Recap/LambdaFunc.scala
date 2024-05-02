package Recap

object LambdaFunc extends App{


  // Lambda functions are commonly used with higher-order functions like map, filter, fold, etc.

  List(1,2,3).map(x=> x+1) // it is lambda function

  val lambda : (Int, Int) => Int = (x:Int, y:Int) => x+y
  val lambda1 : (Int, Int) => Int = (x:Int, y:Int) => x + y
}
