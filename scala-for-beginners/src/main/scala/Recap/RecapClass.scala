package Recap

object RecapClass extends App{

  class sample{
    def value(a:Int): String={
      a.toString
    }
    val variable = "variable"
  }

  // class with constructor
  class sample1 (name : String){
    val nameFromClass = name
  }

  // class with default constructor

  class sample2(name : String, age : Int) {
    def this() = this("yoga", 90)
    def this(name:String) = this (name, 90)
    def this(age:Int) = this("yoga", age)
  }

  // will access the parameter name
  class sample3 (val name : String){
    val peopleName = name
  }

  // private class
  private class PrivateClass {
    def ImInPrivate: String = ""
  }

  // protected class

  protected class ProtectedClass {
    def ImProtectedClass : String = "Im protected"

  }

//  val instanceOfPrivate = new PrivateClass
  val instanceOfProtected = new ProtectedClass

//  println(instanceOfPrivate.ImInPrivate)

  println(instanceOfProtected.ImProtectedClass)

  class sample5 extends ProtectedClass {
    override def ImProtectedClass : String = "hy"
  }

  class sample4 extends sample {
    override def value(a:Int) : String = "hy"
  }


// we cannot able to override the methods belongs to private class
//  class sample6 extends PrivateClass {
//    override def ImInPrivate : String = "overriding private"
//  }


  // private class vs protected class
  // we cannot override the methods of private class
  // we can override the methods of protected class

  class Animal {
    protected val eat = "nom nom nom"
  }

  class Cat extends Animal {
    eat
//    override val eat = "nom"
  }

  // if we declare any private methods or private variable inside the class cannot be accessed outside the class,
  // even if it is extended

  val cat = new Cat
//  println(cat.eat) // protected variable cannot be used outside the class, it will used only in the extended class

  class finalClass {
    final val goal = "goal"
  }
  val finalclassInstance = new finalClass
  println(finalclassInstance.goal) // this final will not be overrided and will be used inside and outside of the class

//  inheritance in the class with constructors

//  class cons1 (val name : String){
//    val newName = name
//  }
//
//  class cons2 (name : String) extends cons1(name){
//    val fromSuperClassName = newName
//
//    def try1 :Unit = {
//
//      println(super.name) // name should be the fields -> val name:String
//    }
//  }
//
//  val trySuper = new cons2("pillow")
//  println(trySuper.try1)
//


  class cons1(val name: String) {
    val newName = name
  }

  class cons2(name: String) extends cons1(name) {
    val fromSuperClassName = newName

    def try1: Unit = {
      println(newName) // Accessing name from cons1
    }
  }

  val trySuper = new cons2("pillow")
  trySuper.try1


  class Animal1 {
    def sound(): String = "Animal sound"
  }

  class Dog extends Animal1 {
    override def sound(): String = {
      val animalSound = super.sound()
      s"$animalSound and bark"
    }
  }


  // we will get the fields and variables from super class using super


  // sealed class, we can extend the sealed class within this file, cannot be extended outside the file.

  // prevention of override

  // method 1 -> use final on methods and fields
  // method 2 -> use final on class, so that the class cannot be extended
  // method 3 -> use sealed on class, so that the class cannot be extended outside the file.

  // abstract method
  abstract class notImplementedClass {
    def method1 (name : String)
    val variable1 : String
  }

//  val tryingToInstantiateAbstractClass = new notImplementedClass {
//    override def method1(name: String): Unit = ???
//
//    override val variable1: String = ???
//  }
  // it acts like an anonymous class

  // we cannot able to instantiate the abstract class
  class class7 extends notImplementedClass{
    def method1(name: String): Unit = println("Hello")
    val variable1 : String = "I'm Implemented"
  }
  // when the abstract classes are extended, then we want to complete all the abstract methods and fields

  trait animal {
    def eat (name : String)

  }

  class class8 extends notImplementedClass with animal{
    def method1(name: String): Unit = println("Hello")
    val variable1 : String = "I'm Implemented"
    def eat (name : String) = ""
  }





}
