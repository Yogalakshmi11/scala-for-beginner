package advance

object PartialFunction extends App{

  val function1 = (x:Int) => x+1

  println(function1(1))

  val aFussyFunction = (x:Int) =>
  if (x ==1) 42
  else if (x == 2) 56
  else if (x == 5) 64
  else throw new FunctionNotFound

  class FunctionNotFound extends RuntimeException

  println(aFussyFunction(1))

  // proper Function
  val aNicerFussyFuction = (x:Int) => x match {
    case 1 => 42
    case 2 => 56
    case 3 => 64
  }

  // A Partial Function

  val partialFunction : PartialFunction[Int, Int] ={
    case 1 => 42
    case 2 => 56
    case 3 => 64
  }
  // Partial Function Utilities
  // 1. definedAt - helps us to check the argument is valid or not, is defined inside the function or not, it gives us boolean

  println(partialFunction.isDefinedAt(19))

  // 2. lift -> if the argument is not defined in the function, instead of getting the error, we get None, like a Option

  println(partialFunction.lift(2))
  println(partialFunction.lift(999))
  // so see it will throw the error for the argument is not defined in the function, instead it is giving None

  // OrElse
  val pfChain = partialFunction.orElse[Int, Int]{
    case 47 => 90
  }
  println(pfChain(47)) // see here, if we are not getting any value from partialFunction, we are creating another new function to get the
  //output

  // partial function extends normal function
  val aTotalFunction : Int => Int={
  case 1 => 9
  }


  // HOFs accepts partial function as well

  val aMappedList = List(1,2,3).map{
    case 1 => 42
    case 2 => 54
    case 3 => 68
  }
  // basically so far I ve understood is, partial function works for pattern matching, that's y we are able to do
  // isDefinedAt, lift, orElse

  // Difference between Function and Partial Function


  /*
  * construct a PF instance yourself (anonymous class)
  * dumb chatbot as a PF
  * */

  val aManualFussyFunction = new PartialFunction[Int, Int]{
    override def apply(v1: Int): Int = v1 match {
      case 1 => 42
      case 2 => 54
      case 3 => 68
    }

    override def isDefinedAt(x: Int): Boolean = {
      x == 1| x==2|x==3
    }
  }

  val chatbot : PartialFunction[String, String] ={
    case "Hi" => "Hello I'm here to help you!"
    case "Thanks for your help" => "You are always welcome!"
  }

  scala.io.Source.stdin.getLines().foreach(line => println(chatbot(line)))
}
