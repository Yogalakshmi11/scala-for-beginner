package ClassPackage

object OverrideOverload {

  class A {
    private def a () {println("hello I'm a method without parameter")}

    def a (name:String) :String={
      println("hello I'm a method with parameter but the the two methods name are same")
      name
      }
  }

}
