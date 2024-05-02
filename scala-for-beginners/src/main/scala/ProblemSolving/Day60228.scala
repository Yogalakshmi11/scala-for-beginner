package ProblemSolving

import scala.annotation.tailrec

object Day60228 extends App{

//  First Reverse
  //Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order.
  // For example: if the input string is "Hello World and Coders"
  // then your program should return the string sredoC dna dlroW olleH.

  def FirstReverse(str:String) : String ={
    str.reverse
  }
  println(FirstReverse("I Love Coding"))

//  First Factorial
  //Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it.
  // For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24.
  // For the test cases, the range will be between 1 and 18 and the input will always be an integer.

  def FirstFactorial(num:Int, acc:Int =1) :Int ={
    if (num < 1) acc *1
    else acc * FirstFactorial(num -1, num)
  }
  println(FirstFactorial(5,1))


  def FirstFactorial1(num:Int, acc:Int =1) :Int ={
    if (num < 1) acc *1
    else  FirstFactorial1(num -1, acc *num)
  }
  println(FirstFactorial1(40000,1))

//  Longest Word
  //Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string.
  // If there are two or more words that are the same length, return the first word from the string with that length.
  // Ignore punctuation and assume sen will not be empty. Words may also contain numbers,
  // for example "Hello world123 567"

  def LongestWord(sen : String) : String ={

    val getMatches = "\\b[A-z]*\\b".r.findAllMatchIn(sen).toList
    getMatches.maxBy(_.toString().length).toString()

  }
  println(LongestWord("oxford press 123456789"))

}


