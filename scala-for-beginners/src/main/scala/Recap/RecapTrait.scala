package Recap

object RecapTrait extends App{
  trait habitat {
    def eat (name :String) : String
    def eatCompleted(name:String) : String = "Hy I'm Implemented Already Nom Nom Nom"
  }

  val implementingTrait : habitat = (x:String) => x.toLowerCase
  // we implemented trait
  // trait does not have constructors
  // we can use many traits in one single class using with not like abstract class



}
