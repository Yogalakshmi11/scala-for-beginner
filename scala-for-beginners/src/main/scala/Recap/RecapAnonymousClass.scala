package Recap

object RecapAnonymousClass extends App{
  trait habitat {
    def eat (name : String): String
  }

  val anonymousClass1 = new habitat {
    override def eat(name: String): String = ""
  }
  // code block will be executed first, then class will be created for this, then it will be assigned to the variable

}
