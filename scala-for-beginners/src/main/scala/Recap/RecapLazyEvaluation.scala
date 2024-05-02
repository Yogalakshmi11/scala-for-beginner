package Recap

object RecapLazyEvaluation extends App{

  lazy val takeTime = 1


//  Call by Value (CBV):
  //In call by value, the argument expression is evaluated before it is passed to the function.
  //The value resulting from the evaluation is then passed to the function.
  //Subsequent accesses to the parameter within the function will use this precomputed value.
  //Call by value is the default evaluation strategy in most programming languages, including Scala.

//  Call by Name (CBN):
  //In call by name, the argument expression is not evaluated before it is passed to the function.
  //Instead, the expression itself is passed, and it is evaluated each time it is accessed within the function.
  //This lazy evaluation behavior means that the expression is evaluated only when it is needed inside the function.
  //Call by name is indicated by using => before the parameter type in the function signature.

  def calculateDiff (x:Int, y  : =>  Int): Int = {
    x -y
  }
  // => call by name

}
