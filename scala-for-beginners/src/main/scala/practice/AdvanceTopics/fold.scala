package practice.AdvanceTopics

object fold extends App{

  //  Sum of Squares:
  //
  //Calculate the sum of squares of all elements in a list using foldLeft.
  //Calculate the sum of squares of all elements in a list using foldRight.
  //String Concatenation:
  //
  //Write a function to concatenate all strings in a list using foldLeft.
  //Write a function to concatenate all strings in a list using foldRight.
  //List Reversal:
  //
  //Implement a function to reverse a list using foldLeft.
  //Implement a function to reverse a list using foldRight.
  //Filter and Fold:
  //
  //Use foldLeft to filter out even numbers from a list and then calculate their sum.
  //Use foldRight to filter out even numbers from a list and then calculate their sum.
  //String Reversal:
  //
  //Write a function to reverse a string using foldLeft.
  //Write a function to reverse a string using foldRight.
  //List Flattening:
  //
  //Implement a function to flatten a list of lists into a single list using foldLeft.
  //Implement a function to flatten a list of lists into a single list using foldRight.
  //String Length Calculation:
  //
  //Calculate the total length of all strings in a list using foldLeft.
  //Calculate the total length of all strings in a list using foldRight.
  //Matrix Transposition:
  //
  //Write a function to transpose a matrix represented as a list of lists using foldLeft.
  //Write a function to transpose a matrix represented as a list of lists using foldRight.


  //  Implement a function to find the sum of all elements in a list using foldLeft.
  val sampleList = List(1,2,3,4,5,6,7,-8)
  val sum = sampleList.foldLeft(0)(_+_)
  println(s"Sum using Fold Left ==>  $sum")

  //  Write a function to concatenate all strings in a list using foldRight.
  val sampleStringList = List("scala", "learn", "to", "gpt", "chat", "using", "am", "I")
  val concateString = sampleStringList.foldLeft("")((acc, ele)=> acc + " " + ele)
  val concateStringLeft = sampleStringList.foldRight("")((ele, acc)=> ele + " " + acc)
  println(s"Concatenate String  using Fold Right ==> $concateString")
  println(s"Concatenate String  using Fold Left ==> $concateStringLeft")

  // foldLeft
  val string1 = List("scala", "learn", "to", "gpt", "chat", "using", "am", "I")
  val foldLeft1 = string1.foldLeft("")((acc, ele) => acc + " " + ele)
  val foldRight1 = string1.foldRight("")((ele, acc) => ele + " " + acc)

  val list1 = List(1, 2, 3, 4, 5, 6, 7, 8)
  // Add
  val foldLeft2 = list1.foldLeft(0)((acc, ele) => acc + ele*ele)
  val foldRight2 = list1.foldRight(0)((ele, acc) => ele * ele + acc)
  // Sub
  val foldLeft3 = list1.foldLeft(0)((acc, ele) => acc - ele * ele)
  val foldRight3 = list1.foldRight(0)((ele, acc) => ele*ele - acc)
  //Reverse
  val foldLeft4 = list1.foldLeft(List.empty[Int])((arr, ele) => ele :: arr)
  val foldRight4 = list1.foldRight(List.empty[Int])((ele, arr) =>  arr :+ ele )
  println(foldLeft4)
  println(foldRight4)
  // Filter and Fold
  val foldLeft5 = list1.filter(x => x % 2==0).foldLeft(0)((acc, ele)=> acc + ele)
  val foldRight5 = list1.filter(x => x % 2==0).foldRight(0)((ele, acc)=> ele + acc)

  val string2 = "Hello I'm Yoga"
  val foldLeft6 = string2.foldLeft("")((acc, ele)=> ele + acc)
  val foldRight6 = string2.foldRight("")((ele, acc) => acc + ele)

  println(foldLeft6)
  println(foldRight6)

  //  List Flattening:
  //  Implement a function to flatten a list of lists into a single list using foldLeft.
  //  Implement a function to flatten a list of lists into a single list using foldRight.

  val listOfList :List[List[Int]] = List(List(0,1,2,3), List(4,5,6,7), List(8,9,10))
  val foldLeft7 = listOfList.foldLeft(List.empty[Int])((arr, ele) => arr ::: ele)
  val foldRight7 = listOfList.foldRight(List.empty[Int])((ele, arr) => ele ::: arr)
  println(foldLeft7)
  println(foldRight7)

  //String Length Calculation:
  //
  //Calculate the total length of all strings in a list using foldLeft.
  //Calculate the total length of all strings in a list using foldRight.
  val foldLeft8 = string1.foldLeft(0)((arr, ele) => arr + ele.length)
  val foldRight8 = string1.foldRight(0)((ele, arr) => ele.length + arr)
  println(foldLeft8)
  println(foldRight8)


//  Matrix Transposition:
  //
  //Write a function to transpose a matrix represented as a list of lists using foldLeft.
  //Write a function to transpose a matrix represented as a list of lists using foldRight.


  // Implement a function to compute the factorial of a number using foldLeft or foldRight.
  val number = 9
  val factorial = Range(1,9+1).toList.foldLeft(1)((acc, ele) => acc * ele)
  println("factorial",factorial)

  def factorialFoldLeft(number: Int): Int = {
    require (number > 0, "Factorial is only defined for non-negative integers")
    (1 to 9).foldLeft(1)((acc, ele)=> acc * ele)
  }

  def factorialFoldRight(number: Int): Int = {
    require(number > 0, "Factorial is only defined for non-negative integers")
    (1 to 9).foldRight(0)((ele, acc) => ele * acc)
  }

//  Calculate the length of a list using fold.
  val  calculateLen = list1.foldLeft(0)((acc, ele)=> acc +1)
  println(calculateLen)
  val  calculateLen1 = list1.foldRight(0)((ele, acc)=> acc +1)
  println(calculateLen1)

  val isPostive = sampleList.foldLeft(true)((acc, ele) => ele > 0)
  println(isPostive)

  val nestedList = List(List(1,2,3), List(4,5,6))
  val foldFlatList = nestedList.fold(List.empty[Int])((acc, ele) => acc ::: ele)
  println(foldFlatList)


  //  List Flattening:
  //  Implement a function to flatten a list of lists into a single list using foldLeft.
  //  Implement a function to flatten a list of lists into a single list using foldRight.
  val testListOfList = List(List(1,2), List(0,9))
  val test = testListOfList.foldRight(List.empty[Int])((acc, ele) => acc ::: ele)
  print(test)
}


