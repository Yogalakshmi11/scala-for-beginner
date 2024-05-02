package advance

object PatternMatchingAdvance extends App {
  val number : Int = 9

  val example1 = number match {
    case x if x < 10 => "Single Digit"
    case x if x % 2 == 0 => "Even Number"
    case _ => "Double Digit and Odd"
  }

  println(example1)

  // we can do this by using object
  object singleDigit {
    def unapply(n:Int) : Boolean = n < 10
    // we can give any name for this methods, not only unapply
  }
  object even{
    def unapply(n:Int) : Boolean = n%2 == 0
  }

  val example2 = number match{
    case singleDigit => "Single Digit"
    case even => "Even Number"
    case _ => "Double Digit and Odd"
  }

  println(example2)
}
