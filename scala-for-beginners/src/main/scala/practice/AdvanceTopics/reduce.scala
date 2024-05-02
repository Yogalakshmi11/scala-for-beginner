package practice.AdvanceTopics

object reduce extends App {
  //  Sum of Elements:
  //Write a function to compute the sum of elements in a list using reduce.
  //
  //Product of Elements:
  //Write a function to compute the product of elements in a list using reduce.
  //
  //Concatenate Strings:
  //Write a function to concatenate all strings in a list using reduce.
  //
  //Find Maximum Element:
  //Write a function to find the maximum element in a list using reduce.
  //
  //Find Minimum Element:
  //Write a function to find the minimum element in a list using reduce.
  //
  //Count Odd Numbers:
  //Write a function to count the number of odd elements in a list using reduce.
  //
  //Check if All Elements are Positive:
  //Write a function to check if all elements in a list are positive using reduce.
  //
  //Check if Any Element is Negative:
  //Write a function to check if any element in a list is negative using reduce.
  //
  //Join List of Lists:
  //Write a function to join a list of lists into a single list using reduce.
  //
  //Matrix Multiplication:
  //Write a function to perform matrix multiplication using reduce.
  val sampleList = List(1,2,3,4,5,6,7,8)
  val reduce1 = sampleList.reduce((a,b) => a+b)
  println(reduce1)
  val reduce2 = sampleList.reduce((a,b) => b-a)
  println(reduce2)
  val reduce3 = sampleList.reduce((a,b) => a * b)
  println(reduce3)
  val sampleString = List("a", "b", "c", "d", "e")
  val reduce4 : String= sampleString.reduce((a,b) => a + b)
  println(reduce4)
  val reduce5 = sampleList.reduceOption((a,b) => if (b>a) b else a )
  println(reduce5)
  val reduce6 = sampleList.reduceOption((min, current) => if (current > min) min else current)
  println(reduce6)
  val reduce7 = sampleList.reduceOption((a,b) => if (b%2!=0) a+1 else a)
  println(reduce7)
  val reduce8 = sampleList.reduceOption((a,b) => if(b%2 ==0) a + 1 else a)
  println(reduce8)

  val nestedList = List(List(1,2,3), List(4,5,6))
  val reduce9 = nestedList.reduce((acc, ele) => acc ::: ele)
  println(reduce9)

}
