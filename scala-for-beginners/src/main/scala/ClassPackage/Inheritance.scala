package ClassPackage

object Inheritance extends  App{

   class versionA(val name:String){
     protected def a():String={
      println("hello I'm version A")
       "hello"
    }
  }
  class versionB(name:String) extends versionA("yoga") {
    override def a():String={
      val bName = name
//      val aName = super.name // here I want to get the name given to versionA class
//      aName
      "yo"
    }
    def b(): Unit = {

      println("hello I'm version B")
    }
  }

  class versionC extends versionB("pavi") {
    def c(): Unit = {
      println("hello I'm version B")
    }
  }

  // this is called multiple inheritance

  val c = new versionB("Pavi")
//  c.a()
  c.b()
//  c.c()

}
