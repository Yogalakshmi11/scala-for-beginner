package Part1Basics

object DefaultConstructor extends App{
  class Constructor (name:String, age : Int){
    def this() = this("yoga", 9) // setting default parameter
    def this(name:String) = this (name, 9)
    def this (age:Int) = this("yoga", age)
  }

  val con = new Constructor(9)


  // RECALL
  class Trail (val name : String, val age : Int) {
    def this () = this ("yoga", 23)
    def this (name : String) = this (name,23)
    def this (age : Int) = this ("yoga", age)
  }

  val trail = new Trail()
  println(trail.age)

  val trail1 = new Trail(90)
  println(trail1.age)

  val trail2 = new Trail("key")
  println(trail2.name)


  // RECALL CONTINUATION

  class Trail2 (val name : String, val age : Int){
    def this () = this ("yoga", 9)
    def this (name : String) = this (name , 9)
    def this(age : Int) = this ("yoga", age)
  }

  val trail3 = new Trail2()
  println(trail3.age)
}
