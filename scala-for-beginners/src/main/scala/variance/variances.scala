package variance

import java.util

object variances extends App{


  trait Animal
  class Cat extends Animal
  class Dog extends Animal
  class Cage[T]

  // covariance
  class CCage[+T]

  //invariance
  class ICage[T]

  val ccage : CCage[Animal] = new CCage[Cat]
  val icage : ICage[Animal] = new ICage[Animal] // => this is correct
//  val icage : ICage[Animal] = new ICage[Cat] => this is wrong

  // invariance => same type to type
  // variance => different type to different type

  // contra variance -> direct opposite => subtype to type => cat to animal not animal to cat
  class XCage[-T]

  val xcage : XCage[Cat] = new XCage[Animal]
  val x1cage : XCage[Animal]  = new XCage[Animal]
//  val x2cage : XCage[Animal]  = new XCage[Cat] => this is wrong


  // covariant example
  var listOfString = List("Hello")
  var listOfAny = List(1, "KI")
  listOfAny = listOfString
  // list of any to list of string is covariance

  import java.util.ArrayList

  var ArrayListOfString : ArrayList[String] = new ArrayList[String]
  var ArrayListOfAny : ArrayList[Any] = new util.ArrayList[Any]

//  ArrayListOfAny = ArrayListOfString -> this is the example for invariant
// class are invariant in scala

  class Animals
  class Dogs extends Animals
  class Container[A](value : A) {
    def getValue(value : A) : A = value
  }

  var DogsContainer = new Container[Dogs](new Dogs)
//  var AnimalContainer : Container[Animal] = DogsContainer -> it throws error, since the classes are invariant in default


  // covariant
  import java.util.ArrayList
  def printAnimals[T <: Animals](animalList:util.ArrayList[T]) ={
    for (x <- 0 until animalList.size){
      println(animalList.get(x))
    }
  }

//  +T (Covariance):
  //+T is used to declare that a type parameter T is covariant, meaning that if A is a subtype of B, then Container[A] is a subtype of Container[B].
  //It allows widening the type hierarchy for the type parameter.
  //Example: class Container[+T] { ... }
  //T <: Bound (Upper Bound):
  //T <: Bound specifies an upper bound for the type parameter T, meaning that T must be a subtype of Bound.
  //It restricts the types that can be substituted for the type parameter to those that are subtypes of Bound.
  //Example: def process[T <: Animal](animal: T): Unit { ... }

  val ArrayListOfDogs = new util.ArrayList[Dogs]
  ArrayListOfDogs.add(new Dogs)
  printAnimals(ArrayListOfDogs)

  // if we aer using +T , any type can be mapped to any type
  // if we are using T <:, the classes which extends the main class will be mapped
  // covariance use cases,
  // we will write a generic method with upper bound type class with main class
  // so that all the child classes are able to make use of the method without need to create separate separate method for each
  // child classes

  // we can do like this also
  class Printer[+T]{
    def printAnimals[T](animalList:util.ArrayList[T]) ={
      for (x <- 0 until animalList.size){
        println(animalList.get(x))
      }
    }
  }

  new Printer[Dogs].printAnimals(ArrayListOfDogs)


  // contravariance

  def copyFrom (dogList1 : util.ArrayList[Dogs], dogList2:util.ArrayList[Dogs]) : Unit = println("Can Copy...!!")

  val dogList1 = new util.ArrayList[Dogs]
  val dogList2 = new util.ArrayList[Dogs]

  copyFrom(dogList1, dogList2)

  val animal1 = new util.ArrayList[Animals]

    def copyFrom1[D, S >: D](  dogList1: util.ArrayList[D],  dogList2: util.ArrayList[S]): Unit = println("Can Copy...!!")

  // S is super class
  // D is derived class

  copyFrom1(dogList1, animal1)

  // covariant -> upper bound to child classes
  // contravariant -> lower bound to super class

  def printer[T <:Animals](animalList : util.ArrayList[T]): Unit = {
    println("Hi")
  }
  // here what are the classes are child classes to Animal, will have the access to this method

  def printerContra[D, S >: D](dog1 : util.ArrayList[D], dog2 : util.ArrayList[S]): Unit = {
    println("Hy")
  }

  // here derived class should extend the super class, then the super class will have the access to this method


  // -T
  class Printer2[-T]


    def contra (dogList:Printer2[Dogs]): Unit = {
      println("HI Contra")
    }


  contra(new Printer2[Animals])







}
