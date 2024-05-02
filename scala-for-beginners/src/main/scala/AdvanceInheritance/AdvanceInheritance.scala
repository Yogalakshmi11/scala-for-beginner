package AdvanceInheritance

object AdvanceInheritance extends App{

  // diamond problem
  trait Animal {
    def name :  String
  }
  trait Lion extends Animal {
    override def name: String = "Lion"
  }

  trait Tiger extends Animal{
    override def name: String = "Tiger"
  }

  class Mutant extends Lion with Tiger{
    println(name)
  }

  println(new Mutant)
  // so here we will get the name as Tiger, because in this diamond problem, the last overrided name will be taken as name



}
