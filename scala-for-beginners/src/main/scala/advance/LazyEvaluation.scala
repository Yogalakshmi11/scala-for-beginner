package advance

object LazyEvaluation extends App {
  def retriveMagicValue : Int ={
    Thread.sleep(1000)
    println("waiting")
    42
  }
  def byNameMethod(n: => Int) :Int ={
    lazy val t = n
    t+t+t
//    n+n+n
  }
  println(byNameMethod(retriveMagicValue))
}
