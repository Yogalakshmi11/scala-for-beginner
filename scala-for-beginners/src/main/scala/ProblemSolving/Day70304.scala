package ProblemSolving

import scala.collection.mutable


object Day70304 extends App{
  //You probably know the "like" system from Facebook and other pages. People can "like" blog posts,
  // pictures or other items.
  // We want to create the text that should be displayed next to such an item.
  //
  //Implement the function which takes an array containing the names of people that like an item.
  // It must return the display text as shown in the examples:
   def likes(liked_person:Array[String]): String={
     val length: Int = liked_person.length
     var string : String = ""
    if (length==0){
      string =  "no one likes this"
    }
    else if (length == 1){
      string =  s"${liked_person(0)} likes this"
    }
    else if (length==2){
      string =  s"${liked_person(0)} and ${liked_person(1)} like this"
    }
    else if (length==3){
      string =  s"${liked_person(0)}, ${liked_person(1)} and ${liked_person(2)} like this"
    }
    else if (length>=4){
      string =  s"${liked_person(0)}, ${liked_person(1)} and ${length - 2} others like this"
    }
     string
  }

  println(likes(Array("a", "b", "c", "d")))

  def likeV1(liked_person:Array[String]): String={
    liked_person.length match {
      case 0 => "no one likes this"
      case 1 => s"${liked_person(0)} likes this"
      case 2 => s"${liked_person(0)} and ${liked_person(1)} like this"
      case 3 => s"${liked_person(0)}, ${liked_person(1)} and ${liked_person(2)} like this"
      case _ => s"${liked_person(0)}, ${liked_person(1)} and ${liked_person.length - 2} others like this"
    }
  }
//  def likeV2(liked_person:Array[String]): String ={
//    liked_person match {
//      case Array() => "no one likes this"
//      case Array(x) => s"${liked_person(0)} likes this"
//      case Array(x, y) => s"${liked_person(0)} and ${liked_person(1)} like this"
//      case Array(x,y,z) => s"${liked_person(0)}, ${liked_person(1)} and ${liked_person(2)} like this"
//      case Array(x, y,z*) => s"${liked_person(0)}, ${liked_person(1)} and ${liked_person.length - 2} others like this"
//    }
//  }

  // Count the number of Duplicates
  // Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
  // that occur more than once in the input string. The input string can be assumed to contain only alphabets
  // (both uppercase and lowercase) and numeric digits

  def countDuplicatesv0(str:String):Int ={
    val charCounts = str.foldLeft(mutable.Map[Char, Int]().withDefaultValue(0))({(acc, ele)=>
      if (ele.isLetterOrDigit)
      acc + (ele -> (acc(ele) + 1))
      else acc
    })
    charCounts.count{case (_,count)=> count >1}

  }
  def countDuplicates(inputString: String): Int = {
    // Convert input string to lowercase to make case-insensitive
    val lowercaseInput = inputString.toLowerCase

    // Use foldLeft to accumulate character counts
    val charCounts = lowercaseInput.foldLeft(Map[Char, Int]().withDefaultValue(0)) {
      (acc, char) =>
        if (char.isLetterOrDigit) acc + (char -> (acc(char) + 1))
        else acc
    }

    // Count the number of characters that occur more than once
    charCounts.count { case (_, count) => count > 1 }
  }

  // Test the function
  val inputString = "abcdeABCDE12233"
  println("Number of duplicates: " + countDuplicates(inputString))




}
