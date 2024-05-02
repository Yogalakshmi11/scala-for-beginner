package collections

object ListvsArray extends App{
  val list = List(1,2,3,4,5,6,7,8,9,10)
  val array = Array(1,2,3,4,5,6,7,8,9,10)
  array(1) = 0 // cannot do this in list
  println(array.mkString(", "))
  println(list.drop(1)) // adding and removing is possible in list, but not in array
  // array - fixed size
  // list - no fixed size
  // array - reassignment by using the index number
  // list - cannot do reassignment by using the index number
}
