package Part1Basics

object InheritanceTraits extends App{
  class Animal {
    private def eat1:String = "nomnom"
    protected def eat:String = "nomnom"
    final def eatter = ""

  }
  class cat extends Animal{
    eat
    eatter
    override def eat :String = "crunch crunch"
  }
  val catClass = new cat
  println(catClass.eat) // without override you cannot call the eat method outside of the subclass
//  println(catClass.eat1) // you cannot call or use the private member of superclass in the subclass

}
