package ProblemSolving

object Day80305 extends App{
  //   // Count the number of Duplicates
  //  // Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
  //  // that occur more than once in the input string. The input string can be assumed to contain only alphabets
  //  // (both uppercase and lowercase) and numeric digits

  def count_duplicate(input: String):Int ={
    def countOfOccurrence(str:String):Map[Char, Int]={
      val records = str.toLowerCase.foldLeft(Map[Char, Int]().withDefaultValue(0)) {
        (arr, char) =>
          if (char.isLetterOrDigit) arr + (char -> (arr(char) + 1))
          else arr
      }
      records
    }
    val occurrenceCount = countOfOccurrence(input).count{case(key, value)=> value > 1}
    occurrenceCount
  }
  println(count_duplicate("AAbbB667UHU"))
  def duplicateCount(str: String): Int =
    str.groupBy(_.toLower).count(_._2.size > 1)
  println(duplicateCount("AAbbB667UHU"))
  println("AAbbB667UHU".groupBy(_.toChar))
  println("AAbbB667UHU".groupBy(_.toChar).count(_._2.size >1) )

//  In this little assignment you are given a string of space separated numbers,
  //  and have to return the highest and lowest number.
def highAndLow(numbers: String): String = {
  val listOfNumber = numbers.split(" ").map(_.toInt)
  val min =listOfNumber.min
  val max = listOfNumber.max
  val highLow = max + " " + min
  highLow
}

  println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))

//  Check to see if a string has the same amount of 'x's and 'o's.
  //  The method must return a boolean and be case insensitive.
  //  The string can contain any char.

  def xo(str: String): Boolean = {
    val xCount = str.toLowerCase.count(p=> p == 'x')
    val oCount = str.toLowerCase.count(p=> p == 'o')
    if (xCount != 0 || oCount != 0) {
      if (xCount == oCount) true
      else false
    }
    else true
  }
  println("xoxoxo".count(p=> p=='x'))
  println(xo("ad"))

//  This time no story, no theory. The examples below show you how to write function accum:
  def accum(s: String): Any = {
//    s.foldLeft(List.empty[String])((acc, ele) => acc :+(ele.toUpper + ele.toLower.toString*(s.indexOf(ele)))).mkString("-")
      s.zipWithIndex.foldLeft(List.empty[String])((acc, ele) =>  acc :+(ele._1.toUpper.toString+ele._1.toLower.toString*ele._2)).mkString("-")
  }
  def accumMap(s: String): Any = {
    //    s.foldLeft(List.empty[String])((acc, ele) => acc :+(ele.toUpper + ele.toLower.toString*(s.indexOf(ele)))).mkString("-")
    s.zipWithIndex.map{
      case(key, value) => key.toUpper.toString+ key.toLower.toString*value
    }.mkString("-")
  }
//  accum("ZpglnRxqenU")
  println(accum("ZpglnRxqenU"))
  println(accumMap("ZpglnRxqenU"))


  
}
