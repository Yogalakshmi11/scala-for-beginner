package advance

object DarkSyntax extends App{
  trait Action{
    def apply(x:Int): String
  }
  val afunkyInstance : Action = (x:Int) => (x+1).toString
  trait Action1 {
    def apply (x :Int) : String
    def re (x:Int):String = ""
  }

  abstract class ActionAbstract {
    def applyAbstract (x:Int) : String
  }

//  if the trait is single abstract method trait, then we can do the following thing
  val singleMethodTrait : Action1 = (x:Int) => (x+1).toString
  val summaTry = (x:Int) => x.toString
  println(singleMethodTrait(1))
  println(summaTry(1))

  val summaTry2 = (x:List[Int]) => {
    x.map(y => y*y)
  }
  println(summaTry2(List(1,2,3,4,5,6)))


 //Dark Syntax 3
  // 2 :: List(1,3,4) -> is possible
  // List(1,2) :: 9 -> is not possible
  // basically it is like -> 2.::(List(1,2,3))
  // :: this operation is right associative
  // 1 :: 2:: 3:: List(4,5)
  // 3:: List(4,5)
  // 2:: List(3,4,5)
  // 1 :: List(1,3,4,5)
  // List(1,2,3,4,5)
  // right associative
  // whenever the name of the function ends with :: it is actually right associative
  // we can define our function in such a way
  // def -->:(x :Int) : Int
  // 3 -->: 2 -->: 1-->: List(4,5,6) --> the implementation is right associative


  // Dark Syntax 4




}
