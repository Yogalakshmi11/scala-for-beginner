package interview

object NilNullNothing extends App{

  val sampleList : List[Int] = Nil
//  sampleList = sampleList ::: List(1,2,3) ---> hence reassignment is not possible
  val sampleString : Seq[Int] = Nil
  
  def throwException1 : Nothing={
    throw new IllegalAccessException("Invalid User")
  }

  println(throwException1)
}
