package ProblemSolving

object Day140317 extends App{
  // The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
  // representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range
  // must be rounded to the closest valid value.
  //
  //Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
  //
  //Examples (input --> output):
  //255, 255, 255 --> "FFFFFF"
  //255, 255, 300 --> "FFFFFF"
  //0, 0, 0       --> "000000"
  //148, 0, 211   --> "9400D3"

  def rgb(r: Int, g: Int, b: Int): String = {
    def convertDecimalToHexadecimal(n: Int):String={
      val quotient = n / 16
      val remainder = n % 16

      val numToAlpha = Map(10 -> 'A', 11 -> 'B', 12 -> 'C', 13 -> 'D', 14 -> 'E', 15 -> 'F')
      if (n <=0) "00"
      else if ( quotient > 9 && remainder > 9) {
        println(n, quotient)
        if (quotient > 15 ) numToAlpha(15).toString + numToAlpha(15).toString
        else if (quotient <= 15 && remainder > 15) numToAlpha(quotient).toString + numToAlpha(15).toString
        else numToAlpha(quotient).toString + numToAlpha(remainder).toString
      }
      else if (quotient > 9 && remainder <= 9) {
        println(n, quotient)
        if (quotient > 15) numToAlpha(15).toString + numToAlpha(15).toString
        else numToAlpha(quotient).toString + remainder.toString
      }
      else if (quotient < 9 && remainder > 9) {
        if (remainder > 15) quotient.toString + numToAlpha(15).toString
        else quotient.toString + numToAlpha(remainder).toString
      }
      else quotient.toString + remainder.toString
    }
    convertDecimalToHexadecimal(r) + convertDecimalToHexadecimal(g) + convertDecimalToHexadecimal(b)
  }

  println(rgb(217, 84, 134))
  println(15.toHexString.toUpperCase())
  println(f"${255 min (217 max 0)}%02X")
  println(f"${217}%02X")

  println(List(217, 84,134).map(x => f"${255 min (x max 0)}%02X"))
}
