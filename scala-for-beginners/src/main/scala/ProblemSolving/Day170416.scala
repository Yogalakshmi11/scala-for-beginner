package ProblemSolving

import scala.collection.mutable

object Day170416 extends App{

  val s1 = "my&friend&Paul has heavy hats! &"
  val s2 = "my friend John has many many friends &"

  def mix(s1: String, s2: String): String = {
    val s1Map = s1.groupBy(_.toString).mapValues(_.length).filter(x =>  x._1 != " ")
    val s2Map = s2.groupBy(_.toString).mapValues(_.length).filter(x =>  x._1 != " ")


    val keys = s1Map.collect {
      case (key, value) => key
    }

    val output: mutable.Map[String, Int] = mutable.Map()
    keys.foreach(x => {

      val s1Collections = s1Map.getOrElse(x, 0)
      val s2Collections = s2Map.getOrElse(x, 0)

      if (s1Collections > s2Collections) {
        if (s1Collections != 1) {
          output.put("1:" + x * s1Collections, s1Collections)
        }
      }
      else if (s2Collections > s1Collections) {
        if (s2Collections != 1) {
          output.put("2:" + x * s2Collections, s2Collections)
        }}

      else {
        if (s1Collections != 1 &&  s2Collections != 1) {
          output.put("=:" + x * s2Collections, s2Collections)
        }
      }
    })
    val finalOutput = output.toList.sortBy(_._2).reverse.collect {
      case (key, value) => key
    }.mkString("/")
    finalOutput
  }

//  println(mix("Are they here", "yes, they are here"))


  //  "abcdef", "abc"
  def lcs(a: String, b: String): String = {
    val aSet = a.toSet
    val bSet = b.toSet
    aSet.intersect(bSet).mkString
  }

//  println("abceff".toSet)

  val l1 = "anothertest"
  val l2 = "notatest"

//  println(l1.intersect(l2).mkString)


//  println("notatest".sliding(2).mkString(", "))

  var i = 0
  while(i != l2.size){
    val subStr = l2(i)
    if (l1.contains(subStr)){
      println(subStr)
    }
    else {
      println(false)
    }
    i+=1
  }




}
