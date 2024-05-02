package practice.HandlingOptions

import scala.:+

object OptionsTry extends App {

  val sampleString : Option[String] = None
  val sampleArray : Option[Array[Int]] = Some(Array(1,2,3,4,6,7,8,9))
  val sampleArray1 : Array[Int]= Array(1,2,3,4,6,7,8,9)
  val sampleString1 : Option[String] = Some("I'm having a string")

  def squareIt(x:Int):Int={
    x*x
  }
  val byFoldString : String = sampleString.fold("")(x => x.toLowerCase)
  val byFoldArray : Array[Int] = sampleArray.fold(Array.empty[Int]){
    arr => arr.foldLeft(Array.empty[Int])({ (acc, x) => acc :+ squareIt(x) })
  }.toArray
  val byFoldArray1 : Array[Int] = sampleArray.fold(Array.empty[Int]){
    x => x.foldLeft(Array.empty[Int])({(acc, x)=> acc :+squareIt(x)})
  }
  val byFoldArray2 : Array[Int] = sampleArray1.foldLeft(Array.empty[Int])((arr,x) => arr:+ squareIt(x))
  println(byFoldArray.mkString(", "))
  val mapDict : Map[String, Array[Int]] = Map("A" -> Array(1), "B" -> Array(1), "C"->Array(1,2))
  val byaFOldMap = mapDict.filter{case (_, arr) => arr.foldLeft(0)(_ + _)==3 }
  val byaFOldMap1 = mapDict.filter(x=>x._2.foldLeft(0)(_ + _) == 1)

  val byaReduceMap = mapDict.filter(x => x._2.reduce(_ + _) ==1)

  println(byaFOldMap)
  println(byaFOldMap)


  val dictValues : Map[String, Array[Int]] = Map("A"-> Array(1,2,3,4), "b" -> Array(1,2))
  val byFoldDictValues : Map[String, Array[Int]] = dictValues.mapValues(arr => arr.foldLeft(Array.empty[Int])((arr,ele)=> arr :+ (ele*ele)))

  val sum : Map[String, Int] = dictValues.mapValues(arr => arr.foldLeft(0)(_ + _))

  println(sum)


  val sampleArray2 : Option[Array[Int]] = Some(Array(1,2,3,4))
  val foldExample = sampleArray2.fold(Array.empty[Int]){
    arr => arr.foldLeft(Array.empty[Int])((arr, ele) => arr :+ ele+ele)
  }
  println(foldExample)

  val sampleArray3 : Option[Array[Int]] = Some(Array(1,2,3,4,5))
  val foldExample1 : Int = sampleArray3.fold(0){
    arr => arr.reduce(_+_)
  }
  println(foldExample1)


//
//  val subByFold : Int = sampleArray.foldLeft(0)({(acc, x) => acc - x})
//  println(subByFold)
//  val subByFold1 : Int = sampleArray1.foldLeft(0)(_ - _)
//  println(subByFold1)

}
