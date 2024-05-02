package ProblemSolving

object Day120311 extends App {
  def stripComments(str: String, markers: Set[Char]): String = {
    val markerString = markers.collect{
      case '-' => "\\-"
      case '.' => "\\."
      case '.' => "\\?"
      case '^' => "\\^"
      case x => x
    }.mkString
    val regexPattern = ("[" + markerString + "]" + ".*").r
    str.replace("\\n", "\n").split("\n").foldLeft(List.empty[String])((acc, ele) => regexPattern.replaceAllIn(ele, "").replace("\\t", "").stripTrailing() :: acc ).reverse.mkString("\n")

  }

  println(stripComments("bananascherriesavocados\\n,pears-\\nwatermelons.\\t  ", Set('#', '!', '^')))
//  println("apples, pears # and bananas\\ngrapes\\nbananas !apples".split("\\n").mkString(",.., "))

}
