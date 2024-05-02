package practice.Collections

object ListThrough extends App{
  val sampleList : List[Int]= List(1,2,3)
  println(0::sampleList) // start of the list
  println(sampleList :+ 4) // end of the list
  println(sampleList ::: List(1,2,3,4) ::: List(12,13,14)) // same as extend in python, creates a new List
  println(sampleList ++ List(5,6,7) ++ List(90))  // same as extend in python, the second list added to the first list last
  println(sampleList ++: List(5,6,7)) // same as extend, pretends that first list should be at the first
  println(sampleList.foldLeft(List.empty[Int])((acc, ele) => acc :+ ele * ele))
  // :\ and :/ fold left and fold right

  val sampleString : List[String] = List()
  "hello" :: sampleString
  println(sampleString)
}
