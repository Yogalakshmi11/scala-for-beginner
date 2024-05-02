package ProblemSolving

import jdk.internal.org.jline.reader.impl.DefaultParser.Bracket

object Day10222 extends App {
  // Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
  //  and return the number of valid combinations that can be formed with num pairs of parentheses.
  //  For example, if the input is 3, then the possible combinations of 3 pairs of parenthesis,
  //  namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()).
  //  There are 5 total combinations when the input is 3, so your program should return 5.

  def BracketCombination(num: Int): Int = {
    var bracketList: List[String] = Nil

    def helper(openCount: Int, closeCount: Int, combo: String): Unit = {

      if (openCount == 0 && closeCount == 0) {
        //        println(bracketList)
        //        println(combo)
        bracketList = combo :: bracketList
        //        println(bracketList)
        return
      }
      if (openCount > 0) {

        helper(openCount - 1, closeCount, combo + "(")
      }
      if (closeCount > openCount) {

        helper(openCount, closeCount - 1, combo + ")")
      }

    }

    helper(num, num, "")
    bracketList.length
  }

  //  println(BracketCombination(3))


  //  val arrayOfString : Array[String] = Array("aaabaaddae", "aed")
  //
  //  val mainString = arrayOfString(0)
  //  val subString = arrayOfString(1).toSet.toArray

  def fetchIndex(str: String, char: Char): List[Int] = {
    var indices: List[Int] = List()
    for ((c, index) <- str.zipWithIndex) {
      if (c == char) {
        indices = indices :+ index
      }
    }
    indices
  }
  //  println(fetchIndex("aaaaabbbbb", 'a'))


  //  val allIndices = subString.foldLeft(List.empty[Int])((acc, ele)=> acc ::: fetchIndex(mainString, ele))

  def countOccurrences(str: String, str2 : String): Map[Char, Int] = {
    // Initialize an empty mutable map to store character counts
    var charCounts: Map[Char, Int] = Map()

    // Iterate through the characters of the string
    for (char <- str) {
      // Update the count for the current character in the map
      if (str2.contains(char)) {
        charCounts = charCounts.updated(char, charCounts.getOrElse(char, 0) + 1)
      }
    }

    // Return the map containing character counts
    charCounts
  }

  def compareSubstrings(str1: String, str2: String): Boolean = {
    // Function to count occurrences of characters in a string
    def countOccurrences(str: String): Map[Char, Int] = {
      str.groupBy(identity).mapValues(_.length)
    }

    // Count occurrences of characters in both strings
    val counts1 = countOccurrences(str1)
    val counts2 = countOccurrences(str2)

    // Check if str1 contains all characters and their counts from str2
    counts2.forall { case (char, count) =>
      counts1.getOrElse(char, 0) >= count
    } && counts2.forall { case (char, count) =>
      counts1.contains(char)
    }
  }

  // Example usage:
//  val str1 = "ksfajeeubsne"
//  val str2 = "jefaa"
//  println(compareSubstrings(str1, str2)) // Output: true


//  println(compareSubstrings("ksfajeeubsne", "jefaa"))

  def minWindow(arrayOfString: Array[String]): String = {

    val mainString = arrayOfString(0)
    val subString = arrayOfString(1).toArray


    var mainIndex = (0 to mainString.length-1).toList
    var tempSubString: String = mainString
    var rightDroppedElement: Int = 0
    var leftDroppedElement: Int = 0
    var leftCheck = false
    var rightCheck = true

    while(!leftCheck && tempSubString != subString.mkString("")){

      leftDroppedElement = mainIndex.reverse.head
      mainIndex = mainIndex.dropRight(1)
      tempSubString = mainString.substring(mainIndex.min, mainIndex.max+1)

      val compare = compareSubstrings( tempSubString,subString.mkString(""))
      if (!compare){
        mainIndex =  mainIndex :+leftDroppedElement
        println(mainIndex)
        tempSubString = mainString.substring(mainIndex.min, mainIndex.max+1)
        leftCheck = true
        rightCheck = false
      }
    }

    while(!rightCheck && tempSubString != subString.mkString("")){
      rightDroppedElement = mainIndex.head
      mainIndex = mainIndex.drop(1)
      tempSubString = mainString.substring(mainIndex.min, mainIndex.max+1)

      val compare = compareSubstrings( tempSubString,subString.mkString(""))

      if (!compare){

        mainIndex = rightDroppedElement :: mainIndex
        tempSubString = mainString.substring(mainIndex.min, mainIndex.max+1)
        rightCheck = true

      }

    }


    tempSubString
  }

  println(minWindow(Array("aabdccdbcacd", "aad")))



}
