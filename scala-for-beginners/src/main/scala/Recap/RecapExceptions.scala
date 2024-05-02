package Recap

object RecapExceptions extends App{

  def getInt(withException: Boolean): Int = {
    if (withException) 42
    else throw new NullPointerException("Hy I'm in exception")
  }

  // we can use try, catch, finally
  // try -> try the actual code to run
  // catch -> catch if there is any error
  // finally -> finally returns nothing, it gives the information from println

  try{
    getInt(false)
  }
  catch{
    case e : RuntimeException => println("Runtime Exception")
    case e : NullPointerException => println("Null Pointer Exception")
  }
  finally{
    println("Everything is completed")
  }

}
