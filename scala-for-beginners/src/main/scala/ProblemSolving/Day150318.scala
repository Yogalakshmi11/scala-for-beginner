package ProblemSolving



object Day150318 extends App{
  //   (Node(
  //        Some(Node(
  //          Some(Node(
  //            None,
  //            None,
  //            1)),
  //          Some(Node(
  //            None,
  //            None,
  //            3)),
  //          8)),
  //        Some(Node(
  //          Some(Node(
  //            None,
  //            None,
  //            4)),
  //          Some(Node(
  //            None,
  //            None,
  //            5)),
  //          9)),
  //        2)
  //Node (1,2,3)

  case class Node(
                   left: Option[Node],
                   right: Option[Node],
                   value: Int
                 )

  import scala.annotation.tailrec

  def treeByLevelsT(node: Node): Seq[Int] = {

    @tailrec
    def eval(currentLevelNodes: Seq[Node], resultAcc: Seq[Int] = Nil): Seq[Int] = {
      val updatedValues = resultAcc ++ currentLevelNodes.map(_.value)
      val nextLevelNodes = currentLevelNodes.flatMap( n => n.left.toList ++ n.right.toList)

      if(nextLevelNodes.isEmpty) {
        updatedValues
      } else {
        eval(
          currentLevelNodes = nextLevelNodes,
          resultAcc = updatedValues
        )
      }
    }

    eval(List(node))
  }

  def treeByLevels(node: Node): Seq[Int] = {

    def evaluate(currentNode:Seq[Node], result:Seq[Int] = Seq()):Seq[Int]={
      val currentNodes = result ++ currentNode.map(_.value)
      val nextNode = currentNode.flatMap(n=> n.left ++ n.right)
      if (nextNode.isEmpty) currentNodes
      else evaluate(nextNode,currentNodes )
    }
    evaluate(List(node))
  }

  println(treeByLevels((Node(
    Some(Node(
      None,
      Some(Node(
        None,
        None,
        3)),
      8)),
    Some(Node(
      None,
      Some(Node(
        None,
        Some(Node(
          None,
          None,
          7)),
        5)),
      4)),
    1))))


  // Given an array X of positive integers, its elements are to be transformed by running the following operation on them as many times as required:
  //
  //if X[i] > X[j] then X[i] = X[i] - X[j]
  //
  //When no more transformations are possible, return its sum ("smallest possible sum").
  //
  //For instance, the successive transformation of the elements of input X = [6, 9, 21] is detailed below:
  //
  //X_1 = [6, 9, 12] # -> X_1[2] = X[2] - X[1] = 21 - 9
  //X_2 = [6, 9, 6]  # -> X_2[2] = X_1[2] - X_1[0] = 12 - 6
  //X_3 = [6, 3, 6]  # -> X_3[1] = X_2[1] - X_2[0] = 9 - 6
  //X_4 = [6, 3, 3]  # -> X_4[2] = X_3[2] - X_3[1] = 6 - 3
  //X_5 = [3, 3, 3]  # -> X_5[1] = X_4[0] - X_4[1] = 6 - 3
  //The returning output is the sum of the final transformation (here 9).
  //
  //Example
  //solution([6, 9, 21]) #-> 9
//  def smallestSum(xs: Seq[Long]): Long = {
//    def eval(xss:Seq[Long], counter:Int):Long ={
//      val ele = xss.head
//      val count = xss.count(x => x == ele)
//      if (count == xss.size) xss.sum
//      else {
//        if
//      }
//    }
//  }

}
