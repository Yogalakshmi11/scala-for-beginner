package ProblemSolving

import scala.collection.immutable.{IndexedSeq, ListMap, NumericRange, WrappedString}

object Day100307 extends App{
  //  Complete the solution so that it splits the string into pairs of two characters.
  //  If the string contains an odd number of characters then
  //  it should replace the missing second character of the final pair with an underscore ('_').


  def solution(s: String): List[String] = {
    val groupedList = (s+"_").grouped(2).toList
    if (groupedList.last.length == 1) {
      groupedList.dropRight(1)
    }else groupedList
  }
  println(solution("skol12"))
  println("sl".grouped(2).map(_.padTo(2, '_')).toList)


  //  Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
  //
  //Example
  //Kata.createPhoneNumber(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)) # => returns "(123) 456-7890"
  //The returned format must be correct in order to complete this challenge.
  //
  //Don't forget the space after the closing parentheses!

  def createPhoneNumber(numbers: Seq[Int]): String = {
    require(numbers.length==10)
    "("+numbers.slice(0,3).mkString("")+")"+" "+numbers.slice(3,6).mkString("")+"-"+numbers.slice(6, 10).mkString("")
  }
  println(createPhoneNumber(Seq(1, 2, 3, 4, 5,6, 7, 8, 9, 0)))
  println(Seq(1, 2, 3, 4, 5,6, 7, 8, 9, 0).take(3))

  //  eureka
  def sumOfPow(n:Int):Int={
    n.toString.zipWithIndex.map(digit => math.pow(digit._1.asDigit,digit._2+1).toInt).sum
  }
  def sumDigPow(a: Long, b: Long): List[Int] ={
    Range.inclusive(a.toInt, b.toInt).filter(n => n== sumOfPow(n)).toList
  }
  println(sumDigPow(10,89))


  //  Write Number in Expanded Form
  //You will be given a number and you will need to return it as a string in Expanded Form. For example:
  //
  //expandedForm 12    -- Should return '10 + 2'
  //expandedForm 42    -- Should return '40 + 2'
  //expandedForm 70304 -- Should return '70000 + 300 + 4'
  //NOTE: All numbers will be whole numbers greater than 0.
  //
  //If you liked this kata, check out part 2!!

  def expandedForm(n:Long):String={
    n.toString.reverse.zipWithIndex.map{case (value, index)=> (value.asDigit*math.pow(10, index)).toLong}.toList.reverse.filter(x=> x!=0).mkString(" + ")
  }
  println(expandedForm(92093403034573L))

//  How can you tell an extrovert from an introvert at NSA?
  //Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.
  //
  //I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
  //According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.
  //
  //For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.
  //
  //Test examples:

  println("This is my first ROT13 excercise!".collect{
    case x if x.toUpper.toInt < 65 || x.toUpper.toInt > 90 => x
    case x if x.isLetter && (x.toInt+13<=90) && x.isUpper => (x.toInt+13).toChar
    case x if x.isLetter && (x.toInt+13>90) && x.isUpper => ((x.toUpper.toInt + 13) - 90 + 64).toChar
    case x if x.isLetter && (x.toUpper.toInt+13<=90) && x.isLower => (x.toUpper.toInt+13).toChar.toLower
    case x if x.isLetter && (x.toUpper.toInt+13>90) && x.isLower => ((x.toUpper.toInt + 13) - 90+64).toChar.toLower
  })
  println(('R'.toInt+13).toChar)
  println(90.toChar)
  println('.'.toInt)
  def rot13(cipher: String): String = {
    cipher.collect{
      case x if x.toUpper.toInt < 65 || x.toUpper.toInt > 90 => x
      case x if x.isLetter && (x.toInt+13<=90) && x.isUpper => (x.toInt+13).toChar
      case x if x.isLetter && (x.toInt+13>90) && x.isUpper => ((x.toUpper.toInt + 13) - 90 + 64).toChar
      case x if x.isLetter && (x.toUpper.toInt+13<=90) && x.isLower => (x.toUpper.toInt+13).toChar.toLower
      case x if x.isLetter && (x.toUpper.toInt+13>90) && x.isLower => ((x.toUpper.toInt + 13) - 90+64).toChar.toLower
    }
  }
  println(rot13(""))

  // [12, 15]  -> "(2 12) (3 27) (5 15)"
  def getPrimeDivisor(n:Int) ={
    val div = Range.inclusive(2, n).filter(x=> n%x == 0).toList
    val primeDiv = div.filter(x => findPrime(x))
    primeDiv
  }
  def findPrime(n:Int):Boolean={
    Range(1, n).filter(x => n % x == 0).toList.length match {
      case 1 => true
      case _ => false
    }
  }

  def sumOfDivided(lst: Array[Int]): String = {
    val divisors : Map[(Int, Int), List[Int]] = lst.zipWithIndex.foldLeft(Map[(Int, Int), List[Int]]())((acc, ele) => acc + (ele -> getPrimeDivisor(ele._1.abs)))
    val collectAllPrime = divisors.flatten(x=> x._2).toSet.toList.sorted.reverse
    val group :Map[Int,List[Int]] = collectAllPrime.foldLeft(Map[Int, List[Int]]())((acc, ele) => acc + (ele -> divisors.collect{
      case x if x._2.contains(ele) => x._1._1}.toList))
    val finalGroup = group.map(x=> x._1->  x._2.sum)
    val result = ListMap(finalGroup.toSeq.sortWith(_._1 < _._1):_*)
    result.toString().replace("->", "").replace(", ", ")(").replace("ListMap", "").replace("  ", " ")

  }

//  println(List(15,21,24,30,45).foldLeft(Map[Int, List[Int]]())((acc, ele) => acc + (ele -> getPrimeDivisor(ele))).flatten(x=> x._2).toSet.collect(x if ))
  println(sumOfDivided(Array(359, 436, 372, 5, -40, 254, 460, 278, 317)))
  println(2)

}
