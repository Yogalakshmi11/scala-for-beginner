package Recap

object RecapNilNullNothing extends App{
  var list : List[String] = Nil
  list +: "Hello"
  list +: "Good Morning"
  list +: Nil

  val string : String = null
  // use none instead

  // NOTHING
  def throwExp : Nothing = throw new NullPointerException("try")

  // NIl
  // 1. Nil is for List
  // 2. Nil can be used as a terminator while appending the elements to the list
  // Null
  // 1. Null is for String
  // 2. Null leads to Null Pointer Exception
  // 3. Use None instead of null
  // Nothing
  // 1. It doesn't produce results
  // 2. It produces abnormal results

}
