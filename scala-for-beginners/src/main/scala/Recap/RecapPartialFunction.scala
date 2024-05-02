package Recap

object RecapPartialFunction extends App{
  // write a function
  val needAInt = (x:Int) => x
  // proper function
  val neeadAProperFunc = (x:Int) => x match{
    case 1 => 1*2
    case 2 => 2*3
    case 3 => 3*4
  }
  // partial function
  val needAPartialFunction  : PartialFunction[Int, Int] ={
    case 1 => 1*2
    case 2 => 2*3
    case 3 => 3*4
  }

  needAPartialFunction.isDefinedAt(1) // is 1 defined in the function
  needAPartialFunction.lift(9) // if the argument is not defined in the function,instead of getting error, we get none
  needAPartialFunction.orElse[Int, Int]{
    case 9 => 9*10
  } // for non defined parameter

  // difference between function and partial function
  // 1. partial function is limited to the set of parameters
  // 2. function is for all the parameters

}
