package ProblemSolving

object Day40226 extends App{
    def counter (str:String):Int ={
      var counter = 0

      def recCounter(str: String, start: Int, count:Int): Unit = {
        println(str)
        if (start == str.length - 1) counter = count

        else if (str(start) == '0' && str(start+1) == '1')  recCounter(str, start+1, count)
        else if (str(start) == '0' && str(start+1) != '1')  recCounter(str.substring(0,start+1) + '1' + str.substring(start+2, str.length), start+1, count+1)
        else if (str(start) == '1' && str(start+1) == '0')  recCounter(str, start+1, count)
        else if (str(start) == '1' && str(start+1) != '0')  recCounter(str.substring(0,start+1) + '0' + str.substring(start+2, str.length), start+1, count+1)
        println("hello")
      }
      recCounter(str, 0, 0)
      counter
    }
  println(counter("0000"))
}
