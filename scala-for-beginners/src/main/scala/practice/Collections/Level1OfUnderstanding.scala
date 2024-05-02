package practice.Collections

object Level1OfUnderstanding extends App{
  // Array vs List
  // IndexedSeq vs LinearSeq
  val arrayOfInt : Array[Int] = Array(1,2,3)
  var listOfInt : List[Int] = List(1,2,3)
  listOfInt = listOfInt :+ 1
//  listOfInt(0) = 2
  arrayOfInt(2) = 9
//  println(listOfInt)
//  println(arrayOfInt.mkString(", "))

//  You are given an array 'ARR' of integers of length N. Your task is to find the first missing positive integer in
  //  linear time and constant space. In other words, find the lowest positive integer that does not exist in the array.
  //  The array can have negative numbers as well.
  //
  //For example, the input [3, 4, -1, 1] should give output 2 because it is the smallest positive number that is
  // missing in the input array.

  def firstMissing(arr: List[Int]):Int={
    val filteredArray = arr.filter(x=> x >= 0 ).sorted.toSet
    if (filteredArray.size == 1){
      1
    }
    else{
      val rangeOfn = (filteredArray.min to  filteredArray.max).toSet

      val positiveInt = rangeOfn.diff(filteredArray)
      if (positiveInt.nonEmpty && filteredArray.contains(1)){
        positiveInt.min

      }
      else if (filteredArray.contains(1)){
        filteredArray.max+1
      }
      else{
        1
      }
    }

  }

//  println(firstMissing(List(3, 2, -6 ,1, 0)))
  println(firstMissing(List(1, 2, 0)))
//1

  //5
  //3 2 -6 1 0
}
