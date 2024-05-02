package practice.Ascii

object ascii extends App{

  val asciiValues = (-125 to 125).map(ascii =>{
    ascii -> ascii.toChar
  }).toMap

  // Printing ASCII values and characters
  asciiValues.foreach { case (value, char) =>
    println(s"$value: $char")
  }
}
