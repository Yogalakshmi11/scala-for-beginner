package practice.AdvanceTopics

object sort extends App {

  //  Sort Strings by Length:
  //Given a list of strings, sort them by their lengths using sortBy.
  //
  //Sort Integers by Absolute Value:
  //Given a list of integers, sort them by their absolute values using sortBy.
  //
  //Sort Strings by Last Character:
  //Given a list of strings, sort them by their last characters using sortBy.
  //
  //Sort Tuples by Second Element:
  //Given a list of tuples, each containing two elements, sort them by their second elements using sortBy.
  //
  //Sort Strings by Number of Vowels:
  //Given a list of strings, sort them by the number of vowels they contain using sortWith.
  //
  //Sort Integers by Their Remainder When Divided by 5:
  //Given a list of integers, sort them by their remainders when divided by 5 using sortWith.
  //
  //Sort Strings by Lexicographic Order, But Ignore Case:
  //Given a list of strings, sort them by lexicographic order (dictionary order), but ignore case using sortWith.
  //
  //Sort Strings by Number of Unique Characters:
  //Given a list of strings, sort them by the number of unique characters they contain using sortWith.
  //
  //Sort Tuples by Sum of Elements:
  //Given a list of tuples, each containing two elements, sort them by the sum of their elements using sortWith.
  //
  //Sort Integers by the Number of Their Divisors:
  //Given a list of integers, sort them by the number of their divisors using sortWith.

  val sampleList = List(3, 4, 1, 9, 8, 7, 6)
  val sort1 = sampleList.sorted
  println(sort1)
  val students = List(("Alice", 85), ("Bob", 73), ("Charlie", 92), ("David", 78))
  val sortBy = students.sortBy(_._2)(Ordering[Int].reverse)
  println(sortBy)


  //  Sort Strings by Length:
  //Given a list of strings, sort them by their lengths using sortBy.

  val sampleListOfString = List("ab", "bcg", "crty", "d", "eetrfy")
  val sort2 = sampleListOfString.sortBy(_.length)
  println(sort2)

  //  Sort Integers by Absolute Value:
  //Given a list of integers, sort them by their absolute values using sortBy.
  val sampleListOfInt = List(1, -2, 3, 4, 5, 6, 7, 8, 9, 10)
  val sort3 = sampleListOfInt.sortBy(_.abs)
  println(sort3)

  //  Sort Strings by Last Character:
  //Given a list of strings, sort them by their last characters using sortBy.

  val sort4 = sampleListOfString.sortBy(_.last)
  println(sort4)


  //  Sort Tuples by Second Element:
  //Given a list of tuples, each containing two elements, sort them by their second elements using sortBy.

  val sampleListOfTuples = List((1, 3), (4, 5), (9, 0))
  val sort5 = sampleListOfTuples.sortBy(_._2)
  println(sort5)

  //  Sort Strings by Number of Vowels:
  //Given a list of strings, sort them by the number of vowels they contain using sortWith.

  def countVowels(inputString: String): Int = {
    inputString.count(c => "aeiou".contains(c))
  }

  val sortWith1 = sampleListOfString.sortWith((a, b) => countVowels(a) > countVowels(b))
  println(sortWith1)

  //  Sort Integers by Their Remainder When Divided by 5:
  //Given a list of integers, sort them by their remainders when divided by 5 using sortWith.

  //  val myList = List(12, 7, 3, 16, 8, 5)
  val sampleList1 = List(12, 7, 3, 16, 8, 5)
  val sort6 = sampleList1.sortBy(_ / 5)
  println(sort6)
  val sortWith2 = sampleList1.sortWith((a, b) => a % 5 < b % 5)
  println(sortWith2)

  val sampleListTuple = List((5, 2), (3, 4))
  val sortBy9 = sampleListTuple.sortBy(_._1)
  println(sortBy9)

  val sampleListString = List("SAMPLES", "Hello", "Apple", "AL")
  val sortWith9 = sampleListString.sortWith((a, b) => a.length < b.length)
  println(sortWith9)
  val sortBy10 = sampleListString.sortBy(_.length)
  println(sortBy10)

  def countCaps(str: String): Int = {
    str.count(c => c.isUpper)
  }

  val sortWith10 = sampleListString.sortWith((a, b) => countCaps(a) > countCaps(b))
  println(sortWith10)

  // if we want to use the builtin methods and sort the values, we can use sortBY
  // if we want to implement some functions and compare and sort the values, for that we can use sortWith, custom comparison

  val sortBy11 = sampleListString.sortBy(countCaps(_))(Ordering[Int].reverse)
  println(sortBy11)

//  Sort Strings by Lexicographic Order, But Ignore Case:
  //Given a list of strings, sort them by lexicographic order (dictionary order), but ignore case using sortWith.

  val sortWith11 = sampleListString.sortWith((a,b) => a.toLowerCase > b.toLowerCase)
  println(sortWith11)

//  Sort Strings by Number of Unique Characters:
  //Given a list of strings, sort them by the number of unique characters they contain using sortWith.
  val sortWith12 = sampleListString.sortWith((a,b) => a.toSet.size < b.toSet.size)
  println(sortWith12)

//  Sort Tuples by Sum of Elements:
  //Given a list of tuples, each containing two elements, sort them by the sum of their elements using sortWith.
  val sortWith13 = sampleListOfTuples.sortWith((a,b) => a._1+a._2 > b._1+b._2)

  println(sortWith13)

//  Sort Integers by the Number of Their Divisors:
  //Given a list of integers, sort them by the number of their divisors using sortWith.
  def numberOfDivisors(n:Int) ={
    (1 to n).count(x=> n%x == 0)
  }
  val sortWith14 = sampleList1.sortWith((a,b) => numberOfDivisors(a) > numberOfDivisors(b) )
  println(sortWith14)
  // sorted is normal like python sorted
  // sortBy and sortWith is a custom sort
}
