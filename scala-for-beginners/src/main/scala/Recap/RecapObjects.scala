package Recap

object RecapObjects extends App{

  // utility function, if the function is independent and it just requires the parameters to run, so then it
  // can be present in the object, then that function will be called as utility function.

  val add = (x:Int, y: Int) => x + y
  val sub = (x : Int, y:Int) => x - y


  // companion object
  class sample{
    val people1 = "pleople1"
    private val people = "private people"
  }

  object sample{
    val people = "people"

    def getVariableFromCompanionClass(sample: sample): String = {
      sample.people
    }

  }
  println(sample.people)  // object is a singleton object, there is no need to instantiated again and again, when it
  // is used, if two variables contains same objects, then both the two variables are same.
  // whereas in class, if class is being instantiated in two variables, then the both the instances are different.
  println(sample.getVariableFromCompanionClass(new sample))



  // things to consider in OBJECTS
  // 1. Entry Point
  // -- If the object with main method, then that object will be the entrypoint for the code to execute
  // 2. Singleton Object
  // -- If the two diff variables contains same object, then both the variables are same.
  // 3. Instantiated Only Once
  // -- Objects are instantiated only once, we can use the methods and variables anywhere in the file, without instantiating again and again.
  // 4. Companion Object
  // -- If class name and object name are same, then the object will be called as companion object.
  // -- all we need to so is, create a method inside the object and use the class inside as a parameter to use the
  // -- private method and private variables
  // 5. Utility Function
  // -- if the function is independent, and if it requires only parameters and if it is present in the object
  // -- it is called as utility function.




}
