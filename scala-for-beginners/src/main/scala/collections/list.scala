package collections

import scala.collection.mutable.ListBuffer

object list extends App{

  var list1 : List[Int] = List(1,2,3,4)
//  val list2 : List[Int] = List(7,8,9,0)
//  val emptyList = Nil // creating empty list using Nil
//  val listByColon = "jan" :: "feb"::"mar":: Nil
//
//
//  // concatenating
//  println(list1:::list2) //concatenating two list using ":::"
//  println(list1 ++ list2) // concatenating two list using "++"
//  println(list1 :+ 0)  // appending using ":+"
//  println(0+:list1) // prepending using "+:"
//  println(list1(2)) // apply method in list -> fetch the element with respect to the given index number
//  println(List(7,8,9)) // apply method to create the list
//  println(listByColon)
//  println(emptyList :+ 1)
//  println(List.range(1,11))
//
//  // experiment on for and foreach
//  for (ele <- list1){
//    println(ele)
//  } // return unit
//  var sum : Int = 0
//  list1.foreach(sum += _)
//  // foreach returns unit
//  println(sum)
//
// val multiply =  for {
//    ele <- list1
//  } yield ele * ele


  val forComprehensionCheck = for {
    x <- list1 if (x < 9)
  } yield x *x

  println(forComprehensionCheck)

  // for comprehension is similar to map, fold map, and all the HOFs

  // map
  val year = List("January", "Febbraury", "March", "APril")
  val shortYear = year.map(_.substring(0,3))
  println(shortYear)
  val zipYear = year.zip(shortYear)
  println(zipYear)
  println(shortYear.exists(x=> x == 3)) // exists in scala
  println(shortYear.startsWith(List("Jan")))  // startswith in scala
  println(shortYear.init) // except the last one, all the elements in the list


  val list = List.range(1,11)
  def reverseList(list:List[Int]) : List[Int] = {
    list match {
      case head :: tail => reverseList(tail) :+ head
      case Nil => List ()
    }
  }

  println(reverseList(list))

  def pickEven(list:List[Int]) : List[Int] ={
    list match {
      case List() => List.empty[Int]
      case head1 :: head2 :: tail => head2 +: pickEven(tail)
    }
  }

  println(pickEven(list))

  // nested HOF
  case class Model (name : String, Price : Int )
  class Phone ( val name : String, val model : List[Model])

  val samsungModel = List(Model("s23", 40000), Model("s21", 30000))
  val googleModel = List(Model("pixel 6a", 25000), Model("pixel 7a", 30000))

  val Phones : List[Phone] = List(
    new Phone ("Samsung", samsungModel),
    new Phone ("Google", googleModel)
  )

  println(Phones.flatMap(phone => phone.model.filter(model => model.Price == 30000).map(phone=> phone.name)))

  println(for {
    phone <- Phones
    model <- phone.model if model.Price == 30000
  } yield  model.name)

  // upper case using recursion

  def toUpperCase(list :List[String]) : List[String]={
    list match{
      case Nil => List()
      case head :: tail => head.toUpperCase :: toUpperCase(tail)
    }


  }

  println(toUpperCase(List("Apple", "Orange", "Mango")))

  val listRange101 = List.range(1, 101)
  val partitionList = listRange101.partition(ele => ele%2 == 0)
  println(partitionList)


  // foldLeft

  println(listRange101.foldLeft(0)(_ + _))

  // reduceLeft
  println(listRange101.reduce(_+_))

  // difference between foldLeft and reduceLeft

  // foldLeft have initial value
  // reduceLeft do not have initial value
  // foldLeft handles the empty list
  // reduceLeft do not handles the empty list, it throws the unsupported exception error

  import scala.collection.mutable.ListBuffer
//  mutable and immutable in scala
  var listMutable = List(1,2,3)
  listMutable = listMutable :+ 4
  println(listMutable)

  val listbuffer : ListBuffer[Int] = ListBuffer(1,2,3,4)
  listbuffer += 5
  listbuffer.prepend(0)


  listbuffer(0) = 20


  //Appending and Prepending:
  //ListBuffer: Well-suited for scenarios where you frequently append or prepend elements to the beginning or end of the buffer, as these operations are efficient.
  //ArrayBuffer: Well-suited for scenarios where you need efficient random access to elements by index or need to insert/remove elements in the middle of the buffer.
  //Memory Overhead:
  //ListBuffer: May have lower memory overhead compared to ArrayBuffer because it only needs to allocate memory for the elements and node references.
  //ArrayBuffer: May have higher memory overhead due to the underlying array structure, especially if the buffer is frequently resized.

  listbuffer.insert(2,21)
  println(listbuffer)

  
}
