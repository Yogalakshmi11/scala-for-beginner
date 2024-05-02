package collections

object set extends App{
  // sets similar to list
  // set do not maintain any order, no index value
  // only unique vale
  // contains different element on same type
  // head , tail, isEmpty, size are available
  // ++ is available, ::: is not available
  val word = Set("I", "am", "Yoga")
  val anotherWord = Set("We", "are", "learning", "Yoga")
  println(word ++ anotherWord)
//  println(word ::: anotherWord) -> not available


}
