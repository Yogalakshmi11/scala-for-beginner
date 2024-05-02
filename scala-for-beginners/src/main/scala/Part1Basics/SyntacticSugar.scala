package Part1Basics

import java.lang
import scala.language.postfixOps



class Mathe(val number: Int) {
  def +(anotherNumber: Mathe): Mathe = {
    new Mathe(this.number + anotherNumber.number)
  }
}


object SyntacticSugar extends App{

  class Person(var name:String,favouriteMovie:String){

    def likes(movie:String):Boolean = movie == favouriteMovie
    def returnName() : String = name
    def apply(alterName:String) : String = {
      name = alterName
      alterName
    }
    def twoMovies(movie1:String, movie2:String) : String = s"${this.name} likes two movies $movie1, $movie2"
    def hangingOut(person : Person):String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${this.name} what the heck?!"

    def isAlive : Boolean = true
  }



  val firstNumber = new Mathe(1)
  val secondNumber = new Mathe(2)
  val thirdNumber: Mathe = firstNumber + secondNumber

  println("Hellow",thirdNumber.number)

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")  // infix notation
  println(mary("Mary")) // apply method
  println(mary returnName())
  println(9 + 0) // here we are adding two numbers  by using the method called "+" calling the method by 9 + 0 rather
  //  than calling the method as 9.+(0) - this is called infix notation
  val tom = new Person("Tom", "Pirates")
  println(mary hangingOut tom)

  // ALL OPERATORS ARE METHODS.

  // UNARY OPERATORS + - ! ~
  // prefix notation
  val x = -1
  val y = 1.unary_-
  println(x)
  println(y)
  println(mary.unary_!)
  println(!mary)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)




}


class sameName(name :String) {
  private val nameVariable:String= name

}



// getter, setter method in scala
class Circle{
  private var rad = 0
  def radius = rad  // getter or reader
  def radius_(number : Int):Int ={ // setter or writer
    if (number < 0) throw new Exception("-ve number is not allowed") else number
    number
  }
}




class Person1(name1:String, age1: Int){
  def name = name1
  val age = age1
  def this(name:String)= this(name, 0)
}

class Adult(name:String, age:Int) extends Person1("Mary"){
  val personName = super.name
  val adultName = name
}


object sameName extends App{
  val same = new sameName("Stella")
  println(same.nameVariable)
  val cls = new Circle
  println(cls radius)
  println(cls.radius_(9))
  val adult = new Adult("John", 9)
  println(adult.personName)
  println(adult.adultName)

}
 // in summary there are three notations
// infix
// prefix
//postfix

// here prefix and postfix doesn't get any parameters like - mary likes "inception"
// prefix means, the method name is at the beginning like -1, !mary
// postfix means the method name is at th end without parameters like mary isAlive
