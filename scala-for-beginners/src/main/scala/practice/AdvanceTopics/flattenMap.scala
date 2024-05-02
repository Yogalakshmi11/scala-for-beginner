package practice.AdvanceTopics

object flattenMap extends App{

  val solution1 = List(List(1,2), List(3,4)).flatMap(x => x.map(_*2))
  val solution2 = List(List(1,2), List(5,6)).flatten
  println(solution2)
}
