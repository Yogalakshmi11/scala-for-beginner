package ImplicitsPractice

object ImplicitPart1 extends App{

  val introToImplicit = "Hello" -> "555"
  // here "hello" is the instance of class
  // -> is the method of the implicit class
  // "555" is the parameter

  case class Person (name : String) {
    def greet = ""
  }

  implicit def fromString(str:String) : Person = Person(str)

  println("hello".greet)

  def increment (x:Int) (implicit amount : Int) = x + amount
//  def increment1 (x:Int, implicit amount : Int)
  implicit val defaultAmount = 10
  println(increment(1))
}
