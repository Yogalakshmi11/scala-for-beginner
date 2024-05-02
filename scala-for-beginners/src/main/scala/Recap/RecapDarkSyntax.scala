package Recap

object RecapDarkSyntax extends App{
  def needANumber (n:Int) : Int = n

  val s = needANumber{
    println("hello")
    42
  }
  // code block to give a parameter
  // try {} => works on this
  // method with single parameter
  // needANumber 1
  // needANumber {42}

  // def < (A:Int, B:Int)
  // 1 < 2
  // def ::
  // right associative
  // .update(2,4)
  // Array[2] = 4


}
