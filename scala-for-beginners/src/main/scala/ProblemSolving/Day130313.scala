package ProblemSolving

import scala.annotation.tailrec

object Day130313 extends App{
//  Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
  //
  // Three 1's => 1000 points
  // Three 6's =>  600 points
  // Three 5's =>  500 points
  // Three 4's =>  400 points
  // Three 3's =>  300 points
  // Three 2's =>  200 points
  // One   1   =>  100 points
  // One   5   =>   50 point
  //A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
  //
  //Example scoring
  //
  // Throw       Score
  // ---------   ------------------
  // 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
  // 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
  // 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
  //In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.


  def score(dice: List[Int]): Int = {
    require(dice.length==5)
    val valueCount = dice.groupBy(_.toInt)
    val tripletPoint = valueCount.filter(_._2.length >= 3)

      val collectTripletPoint = if (tripletPoint.size == 1) {
        tripletPoint.head._1 match {
          case x if x == 1 => 1000
          case x if 2 to 6 contains x => x * 100
        }
      } else 0
    var collectOnesPoint= 0
    val OnesPoint = valueCount.filter( x => x._2.length < 3  || x._2.length> 3).keys.collect {

      case y if y == 1 && valueCount(y).length < 3 => collectOnesPoint += 100 * valueCount(y).length
      case y if y == 5 && valueCount(y).length < 3 => collectOnesPoint += 50 * valueCount(y).length
      case y if y == 1 && valueCount(y).length > 3=> collectOnesPoint += 100 * (valueCount(y).length - 3)
      case y if y == 5 && valueCount(y).length > 3 => collectOnesPoint += 50 * (valueCount(y).length - 3)
      case _ => 0
    }
    collectTripletPoint + collectOnesPoint
  }
  println(score(List(5,5,5,5,5)))

  def fromKata(dice: List[Int]):Int ={

    dice.groupBy(_.toInt).map(x => x._1->x._2.length).map(y=> y._1 match{
      case z if z == 1 => (y._2/3)*1000 + (y._2%3)*100
      case z if z == 5 => (y._2/3)*500 + (y._2%3)*50
      case z if 2 to 4 contains(z) => (y._2/3)* 100
      case z if 5 to 6 contains(z) => (y._2/3)*100
    }).sum
  }
  println(fromKata(List(1,2,3,4,3)))

//  Complete the function that
  //
  //accepts two integer arrays of equal length
  //compares the value each member in one array to the corresponding member in the other
  //squares the absolute value difference between those two values
  //and returns the average of those squared absolute value difference between each member pair.

  def solution(a: Array[Int], b: Array[Int]): Double = {
    println(a.zip(b).map(x => (x._1-x._2)).map(y => y*y).sum.toDouble/14) // double is correct
   (a.zip(b).map(x => (x._1-x._2)).map(y => y*y).sum.toFloat/a.length).toDouble
  }
  println(solution(Array(7, -11, -44, -71, 35, -79, 51, -16, -71, -83, -73, 0, 94, 91), Array(-45, -3, -55, 81, -17, 57, -88, 0, -69, -10, 97, 64, -55, -22)))


  def justify(text: String, width: Int): String = {
    ""
  }
  val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum velit ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor."

//  println(text.split(" ").zipWithIndex.mkString(" ,"))

  def test(text:String, width : Int): String={

    val splitText = text.split(" ").zipWithIndex
    var accumulator = ""

    def testRecursive(textList:Array[(String, Int)], modifiedList : Array[(String, Int)],length : Int = 1, tempAccumulator : String ="", strLength : Int=0):Unit = {

    if (length == text.length || modifiedList.length == 0)  accumulator = accumulator + tempAccumulator.strip()+"\n"
    else if (strLength == width) {
      accumulator = accumulator + tempAccumulator.strip()+"\n"
      testRecursive(textList, modifiedList, length, "", 0)
    }
    else if (strLength < width ) {
      if ((tempAccumulator + modifiedList(0)._1 + " ").length < width  ) testRecursive(textList, modifiedList.drop(1),length + 1, tempAccumulator + modifiedList(0)._1 + " ", (tempAccumulator + modifiedList(0)._1 + " ").length)
      else if ((tempAccumulator + modifiedList(0)._1 + " ").length == width  ) testRecursive(textList, modifiedList.drop(1), length + 1, tempAccumulator + modifiedList(0)._1 + " ", (tempAccumulator + modifiedList(0)._1 + " ").length)

      else if ((tempAccumulator + modifiedList(0)._1).length == width) testRecursive(textList, modifiedList.drop(1),length + 1, tempAccumulator + modifiedList(0)._1 , (tempAccumulator + modifiedList(0)._1).length)

      else if ((tempAccumulator + modifiedList(0)._1 + " ").length > width) {
        accumulator = accumulator + tempAccumulator.strip()+"\n"
        testRecursive(textList, modifiedList, length, "", 0)
      }
    }
    }
    testRecursive(splitText, splitText)
    println(accumulator)
    var collectLines :List[String] = List.empty[String]
    accumulator.strip() .split("\n").foreach(
      line => {
        val words = line.split(" ")
        val totalSpaces = width - line.length
        val numGaps = words.length - 1
        if (numGaps > 0) {
          val baseSpaces = totalSpaces / numGaps
          val extraSpaces = totalSpaces % numGaps
          val spaces = Array.fill(numGaps)(baseSpaces) ++ Array.fill(extraSpaces)(1)
          println(line, words.zip(spaces).mkString("\n"))
          collectLines = collectLines :+ words.zipAll(spaces.reverse, "", 0).map {
            case (word, space) if space != 0 => {
              println(line,word, space)
              (word + " " * (space + 1)).mkString("")
            }
            case (word, space) if space == 0 => word + " "}.mkString("").strip()

        } else collectLines = collectLines :+ line
      }
    )
    collectLines.mkString("\n")
    }
  println(test(text, 15))
  }


