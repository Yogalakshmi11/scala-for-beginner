package ProblemSolving

//"""Bracket Matcher
//  |Have the function BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are
//  correctly matched and each one is accounted for. Otherwise return 0.
//  For example: if str is "(hello (world))", then the output should be 1, but if str is "((hello (world))" the
//  the output should be 0 because the brackets do not correctly match up. Only "(" and ")" will be used as brackets.
//  If str contains no brackets return 1.""".stripMargin

object Day30225 extends App {

  def braketMatcher(str: String) : Int ={


//    val openBracketCount = str.count(x=> x == '(')
//    val closeBracketCount = str.count(x => x == ')')
//    if (openBracketCount == closeBracketCount)  1
//    else  0

//    var a = 0
//
//    str.foreach(x =>{
//      if (x == '(') a +=1
//      else if ( x == ')') a -=1
//
//      if (a == -1) return 1
//      else return 0
//    })
    val openBracket = '('
    val closeBracket = ')'
    var result : Boolean= false
    def Matcher(remaining:String, counter :Int) : Unit ={

      if (counter < 0 || remaining.isEmpty) result = true
      else if (counter == 0 && remaining.head == closeBracket)  result = false
      else if (remaining.head == openBracket) Matcher(remaining.tail, counter +1)
      else if (remaining.head == closeBracket) Matcher(remaining.tail, counter-1)
      else Matcher(remaining.tail, counter)
    }
    Matcher(str,0)
    if (result)  1 else  0

  }

  def BracketMatcher(str: String): Int = {
    val closerBracket: Char = ')'
    val openerBracket: Char = '('

    def BracketMatcherTailRec(remaning: String, openedBrackets: Int): Boolean = {
      println(remaning)
      if (openedBrackets < 0 || remaning.isEmpty) openedBrackets == 0
      else if (openedBrackets == 0 && remaning.head == closerBracket) false
      else if (remaning.head == openerBracket) BracketMatcherTailRec(remaning.tail, openedBrackets + 1)
      else if (remaning.head == closerBracket) BracketMatcherTailRec(remaning.tail, openedBrackets - 1)
      else BracketMatcherTailRec(remaning.tail, openedBrackets)
    }

    if (BracketMatcherTailRec(str, 0)) 1 else 0
  }

  println(BracketMatcher(")"))

}
