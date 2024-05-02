package Recap

object RecapImplicits extends App{

  def increment(x:Int)(implicit amount : Int):Int = x + amount

  implicit val defaultAmount = 10


  def concatenateString(firstString : String) (implicit secondString: String) : String = firstString + secondString

  implicit val defaultString = "Hy"

  println(increment(1))
  println(concatenateString("HI ,"))

}
