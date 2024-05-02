package ProblemSolving

import scala.math.Integral.Implicits.infixIntegralOps
import scala.util.control.Breaks.break

object Day90306 extends App{
  //  Write a function that takes an array of numbers (integers for the tests) and a target number.
  //  It should find two different items in the array that, when added together, give the target value.
  //  The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).
  //
  //For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
  //
  //The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers;
  // target will always be the sum of two different items from that array).
  //
  //Based on: https://leetcode.com/problems/two-sum/

  def twoSum(numbers: List[Int], target: Int): (Int, Int) = {
    val indexValue = numbers.zipWithIndex
    var got = false
    var i = 0
    val length = numbers.length
    var answer : Tuple2[Int, Int] = (0,0)
    while (!got && i != length - 1) {
      indexValue.slice(i+1, length).foreach(ind => {
        if(indexValue(i)._1+ind._1 == target){
          answer = (i, ind._2)
          got = true
        }
      })
      i += 1
    }
    answer
  }
  println(twoSum(List(1,2,3), 4))
  val numbers = List(2, 2,1,  3)
  println(numbers.zipWithIndex.combinations(2).collectFirst{case Seq((a,i),(b,j)) if a+b == 9 => (i,j)}.getOrElse("None"))

  def findNb(m:Long):Int ={
    var n = 1
    var volume :Long= 0

    while (volume < m){
      volume += math.pow(n, 3).toLong
      if (volume == m){
        return n
      }
      n +=1
    }
    -1
  }
  println(findNb(91716553919377L))
  //  The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.
  //  It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80
  //
  //Could you give the sum of the perimeters of all the squares in a rectangle when there are n + 1 squares disposed
  // in the same manner as in the drawing:

  def factorial(n:Int):Int ={
    if (n == 1) 1
    else n * factorial(n-1)
  }
  println(factorial(5))

  def fibonacci(num :BigInt, a:BigInt, b:BigInt, acc:List[BigInt]):List[BigInt] ={
    if (num <0) acc.reverse
    else fibonacci(num - 1, b, a+b, a::acc)
  }

  def perimeter(n: BigInt): BigInt = {
    val ListOfFib = fibonacci(n.toInt+1, 0,1,List())
    4* ListOfFib.sum
  }
  println(perimeter(100))
  println(Range.inclusive(0, 2).toList)

  //  Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
  //  which is the number of times you must multiply the digits in num until you reach a single digit.
  //
  //For example (Input --> Output):
  // 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
  //999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
  //4 --> 0 (because 4 is already a one-digit number)
  def calculateProduct(n:Int):Int ={
    n.toString.toList.foldLeft(List.empty[Int])((acc, ele) => ele.toString.toInt :: acc).product
  }
  def persistence(n: Int, counter:Int =0): Int = {
    if (n.toString.length==1) counter
    else persistence(calculateProduct(n), counter+1)
  }
  println(persistence(4))
  println("91".map(_.asDigit).product)

  def numberToAlphabet(n:Int) : String ={
    ""
  }

  // excel column name
  def generateExcelColumnName(num:Int):String={
    var number = num
    var result = ""
    while (number > 0){
      val (numee, remainder) = (number-1) /% 26
      result= (65 + remainder).toChar+result
      number = numee
    }
    result
  }
  println(generateExcelColumnName(1000))



}





