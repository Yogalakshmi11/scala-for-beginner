package ProblemSolving

object Day50227 extends App{
//  Codeland Username Validation
  //Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:
  //
  //1. The username is between 4 and 25 characters.
  //2. It must start with a letter.
  //3. It can only contain letters, numbers, and the underscore character.
  //4. It cannot end with an underscore character.
  //
  //If the username is valid then your program should return the string true, otherwise return the string false.

  def CodelandUsernameValidation(str: String): String = {
    if (str.length >= 4 && str.length <= 25 && str.head.isLetter && str.last != '_'){

      if (str.forall(p=> p.isLetter || p.isDigit || p =='_')) "true"
      else "false"

    }
    else "false"
  }


//  Find Intersection
  //Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
  // the first element will represent a list of comma-separated numbers sorted in ascending order,
  // the second element will represent a second list of comma-separated numbers (also sorted).
  // Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr
  // in sorted order. If there is no intersection, return the string false.

  def FindIntersection(strArr: Array[String]): String = {
    val firstArrayOfString = strArr.head.split(", ").toSet
    val secondArrayOfString = strArr.last.split(", ").toSet
    val intersection = firstArrayOfString.intersect(secondArrayOfString)
    if (intersection.size >=1) {
      intersection.toList.foldLeft(List.empty[Int])((arr, ele) => ele.toInt :: arr).sorted.mkString(", ")
    } else "false"
  }
  println(FindIntersection(Array("21, 22, 23, 25, 27, 28", "21, 24, 25, 29")))


//  Questions Marks
  //Have the function QuestionsMarks(str) take the str string parameter,
  // which will contain single digit numbers, letters, and question marks, and
  // check if there are exactly 3 question marks between every pair of two numbers that add up to 10.
  // If so, then your program should return the string true, otherwise it should return the string false.
  // If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

  def QuestionsMarks(str: String):Boolean ={
    val regexPattern = "\\d[A-z\\?]*\\d".r
    val subString = regexPattern.findAllMatchIn(str)
    var found = "false"
    subString.foreach(x => {
      println(x)
      if (x.toString().count(p => p== '?') ==3){
        if (x.toString().head.toString.toInt + x.toString().last.toString.toInt== 10) found = "true"

      }
    })
    if (found== "true") true else false
  }
  println(QuestionsMarks("9???1???9???1???9"))
}
