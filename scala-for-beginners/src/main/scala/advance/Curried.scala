package advance

object Curried extends App{
   // function to add two numbers
  val add2 = (x:Int, y:Int) => x+y
  def add2V1(x:Int, y:Int) :Int = x+y
  def curriedAdd2(x:Int)(y:Int):Int = x + y
  val simpleAdd : Int => Int => Int =
    x => y=> x+y

  val adding = simpleAdd(8)
  println(adding(0))

  val simpleAdd1 : Int=>Int=>Int =
    x=> y=> x+y

  //Exercise
  //add7
  val v1 = (x:Int) => add2(9, x) // in normal function, if it is curried, we don't need to put that x
  println(v1(2))

  val functionToCurried = add2.curried(9)
  println(functionToCurried(8))

  val paf = curriedAdd2(8) _  // partially applied function , with or without () (_) or _

  // convert method to curried
  val methodToCurried = add2V1(8, _:Int)
  println(methodToCurried(9))

//  In the above example, addCurried is a curried function. It takes two parameter lists, x: Int and y: Int, separately. When you call this function with just the first parameter list (addCurried(5)), it returns another function that takes the second parameter (y: Int). This allows for partial application of the function, where you can fix some parameters and apply the remaining ones later.
  //
  //Currying can be particularly useful in functional programming paradigms, enabling the creation of new functions from existing ones through partial application, leading to more flexible and composable code.


  // functoin
  val func = (x:Int) => x.toString
  // curried function
  def curried (x:Int)(y:Int):Int = {
  x+y
  }

  // partial function

  val partial = (x:Int) => x match {
    case _ => 1
  }

  val properPartial : PartialFunction[Int, Int] = {
    case 1 => 1
  }

  // partial application function

  val paf1 = curried(1)_
  println(paf1(2))

}
