package Recap

object RecapCaseClass extends App{

  case class Animal(name :String, habitat : String)

  val matchAnimal = Animal("simba", "house")
  println(matchAnimal.name)
  println(matchAnimal.habitat)

  val matchAnimal1 = Animal("simba", "house")
  println(matchAnimal == matchAnimal1)

  val matchAnimal2 = Animal("simba", "terrace")
  println(matchAnimal1 == matchAnimal2)

  // if there are two instance of case class and the parameters are same, then the two instance are same
  // shared memory
  // if any one of the parameters different, then both the instance are different, but the for the same parameter,
  // it shares the memory


  case object caseCompanionObject {
    def try1(name:String) : String = "Mughal"
  }


  println(caseCompanionObject.try1(""))

  val caseMatch = "string" match{
    case x if x == "string" => true
    case _ => false
  }

  println(caseMatch)

  print(matchAnimal1)

  matchAnimal.copy(habitat = "wild")

}
