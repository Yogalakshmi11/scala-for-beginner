package Part1Basics


class DemoObject{
  private val giveInputMember : String = "Daniel"
}


// Explains Companionship between call and object with the same name only.
object DemoObject extends App{
  object Demo {
    println("I'm Instantiated")

    def add(a:Int,b:Int):Int={  // utility function
      a+b
    }
  }
  def getMemberName(instance:DemoObject) : String = instance.giveInputMember

  println(DemoObject.getMemberName(new DemoObject))
  println(Demo.add(1,2))
  println(Demo.add(2,3))
  println(Demo.add(3,4))
  println(Demo)

}
