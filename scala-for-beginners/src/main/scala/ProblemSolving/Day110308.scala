package ProblemSolving

object Day110308 extends App {
  def decompose(n: Long): String= {

    val tot = n * n
    var accumulated = 0L
    var count = 1L
    var listOfEle = List.empty[Long]

    while (tot > accumulated || n - count > 0) {

      val endRange = (n-count).toInt
      Range.inclusive(1, endRange).reverse.foreach { x =>
        val pow = x * x
        accumulated += pow
        if (tot >= accumulated) listOfEle = x :: listOfEle
        else accumulated -= pow
      }




      count += 1L

      if (tot == accumulated ) return listOfEle.mkString(" ")
      else if (n-count > n || n -count <= 0) return null
      accumulated = 0L
      listOfEle = List.empty[Long]
    }

    null

  }
  println(decompose(1234567))

//  println(Range(1, 9).reverse.foreach(x => println(x)))
}
