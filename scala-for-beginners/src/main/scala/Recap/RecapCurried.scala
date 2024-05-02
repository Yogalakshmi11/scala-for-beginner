package Recap

object RecapCurried extends App{

  // function to add 2 numbers

  val addFunc = (x:Int, y:Int) => x+y

  // method to add 2 numbers

  def add (x:Int, y:Int) : Int = {
    x+y
  }

  // curried function to add 2 numbers

  def addCur(x:Int)(y:Int):Int = x+y

  println(addFunc(1,2))
  println(add(1,2))
  val add1 = addCur(1)_
  println(add1(2))

  // convert func to curried function

  val adding =(x:Int)=> addFunc.curried(1)
  adding(2)


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


  val simpleAdd :Int => Int => Int ={
    x => y=> x+y
  }
  val addSimple = simpleAdd(1)
  println(addSimple(2))

  val func1 = (x:Int) => x+1

}
