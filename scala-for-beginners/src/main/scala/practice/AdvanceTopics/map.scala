package practice.AdvanceTopics

object map extends App{

  //  Double the elements: Given a list of integers, write a function to double each element using the map function.
  //
  //Convert strings to uppercase: Given a list of strings, write a function to convert each string to uppercase using the map function.
  //
  //Compute the lengths: Given a list of strings, write a function to compute the length of each string using the map function.
  //
  //Square the elements: Given a list of integers, write a function to square each element using the map function.
  //
  //Add a prefix: Given a list of strings and a prefix string, write a function to add the prefix to each string using the map function.
  //
  //Extract first character: Given a list of strings, write a function to extract the first character of each string using the map function.
  //
  //Compute the absolute values: Given a list of integers, write a function to compute the absolute value of each integer using the map function.
  //
  //Convert to lowercase: Given a list of strings, write a function to convert each string to lowercase using the map function.
  //
  //Multiply each element by its index: Given a list of integers, write a function to multiply each element by its index using the map function.
  //
  //Compute the squares of even numbers: Given a list of integers, write a function to compute the squares of even numbers and leave odd numbers unchanged using the map function.


  // 1. Double the elements: Given a list of integers, write a function to double each element using the map function.
  def doubleIt(n:Int):Int ={
    n*2
  }
  val solution1 = List(1,2,3,4,5,6,7,8,9).map(c=>doubleIt(c))
  println(solution1.mkString(","))

  // 2. Convert strings to uppercase: Given a list of strings, write a function to convert each string to uppercase using the map function.
  def toUpper(str: String) : String={
    str.toUpperCase()
  }

  val solution2 = List("Hello", "HELLO").map(str => toUpper(str))
  println(solution2)

  // 3. Compute the lengths: Given a list of strings, write a function to compute the length of each string using the map function.

  def calculateLength(Str:String) : Int ={
    Str.length
  }
  val solution3 = List("Hello", "Long", "Short").map(c=> calculateLength(c))
  println(solution3)

  // 4. Square the elements: Given a list of integers, write a function to square each element using the map function.
  def squareIt(n:Int) : Int ={
    n*n
  }

  val solution4 = List(1,2,3,5).map(c=>squareIt(c))
  println(solution4)

  // 5. Add a prefix: Given a list of strings and a prefix string, write a function to add the prefix to each string using the map function.
  def prefix(str:String):String ={
    "Prefix" + str
  }
  val solution5 = List("Hello", "String").map(x=> prefix(x))
  println(solution5)

 // 6.  Extract first character: Given a list of strings, write a function to extract the first character of each string using the map function.

  def firstLetter(str:String):Char ={
    str.charAt(0)
  }

  val solution6 = List("Hello", "String").map(x => firstLetter(x))
  println(solution6)

  // 7. Compute the absolute values: Given a list of integers, write a function to compute the absolute value of each integer using the map function.

  def absolute(n:Int):Int ={
    n.abs
  }

  val soliution7 = List(1,2,3,4,5,6,7,8,9,10).map(x=> absolute(x))

  println(soliution7)
  // 8. Convert to lowercase: Given a list of strings, write a function to convert each string to lowercase using the map function.

  def upperCase(str:String):String ={
    str.toLowerCase()
  }

  val solution8 = List("Hello", "String").map(x=> upperCase(x))
  println(solution8)

  // 9. Multiply each element by its index: Given a list of integers, write a function to multiply each element by its index using the map function.

  def multipleByIndex(n:Int, Index:Int) :Int ={
    n*Index
  }

//  val solution9 = List(1,2,3,4,5,6,7,8,9,10).map(x=>multipleByIndex(x))

  println(List(1,2,3,4).zipWithIndex.map(x => x._1*x._2))

  // 10. Compute the squares of even numbers: Given a list of integers, write a function to compute the squares of even numbers and leave odd numbers unchanged using the map function.

  def isEven(n:Int):Int={
    if (n%2==0)    n*n
    else  n

  }

  val solution10 = List(1,2,3,4,5,6,7,8,9,10).map(x=> isEven(x))
  println(solution10)

  val solution11 = List((1,2),(3,4)).map(x=> x._2 * 8)

  def isEven1(n:Int):List[Int]={
    if (n%2==0)    List(n*n)
    else  List(n)

  }

  val solution12 = List(List(1,2), List(3,4)).map(_.flatMap(isEven1))


  println(solution12.mkString(","))

}
