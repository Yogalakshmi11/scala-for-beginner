package practice.AdvanceTopics

object ForComprehension extends App{
  val sampleList : List[Int]  = List(1,2,3,4,5)
  val sampleDoubleList = for (i <- sampleList) yield i*i
  println(sampleDoubleList)

  // for comprehension and yield is more powerful without alternating the orginal list it does the functionality and
  // creates the new list with updated values
  val numbers : List[Int] = List(1,2,3,4)

  val updatedNumbers = for {
    num <- numbers
    if num%2==0}
   yield
  {
    num * num
  }

  println(updatedNumbers)
}
