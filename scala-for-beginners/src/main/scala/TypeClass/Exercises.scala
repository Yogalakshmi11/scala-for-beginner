package TypeClass

object Exercises extends App{

  implicit class RichString(value:String) {
    def asInt: Int = Integer.valueOf(value)

    def cipher : String = value.map(character => (character.toInt + 2).toChar)
  }

  "john".cipher

  implicit def StringToInteger(value : String): Int ={
    Integer.valueOf(value)
  }
  // this is the power of implicit
  println("4" / 4)

  // methods consumes function as a parameter
  val incrementElement = (x:Int) => x+1

  def foreach(x : Int , f:Int => Int): Int = f(x)
  println(foreach(1, incrementElement))
}
