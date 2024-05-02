package ProblemSolving

object Day160415 extends App {

  val RomanLetters: Map[String, Int] = Map(
    "M" -> 1000,
    "D" -> 500,
    "C" -> 100,
    "L" -> 50,
    "X" -> 10,
    "V" -> 5,
    "I" -> 1
  )

  val romanNumerals = Seq(
    1000 -> "M",
    900 -> "CM",
    500 -> "D",
    400 -> "CD",
    100 -> "C",
    90 -> "XC",
    50 -> "L",
    40 -> "XL",
    10 -> "X",
    9 -> "IX",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )

  def fromRoman(roman : String):Int={
    var prevValue = 0
    var result = 0
    val reverseString = roman.reverse
    reverseString.foreach(x=>{
      val value = RomanLetters(x.toString)
      if (value < prevValue){
        result -= value
      }
      else {
        result += value
        prevValue = value
      }
    })
    result
  }


  def toRoman(number:Int):String={
    var remaining = number
    var result = ""

    for ((value, symbol) <- romanNumerals){
      println(symbol, value)
      while(remaining >= value){

        result += symbol
        remaining -= value
      }
    }
    result
  }


  println(toRoman(1974))
}
