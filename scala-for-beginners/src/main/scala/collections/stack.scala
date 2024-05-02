package collections

object stack extends App{
  import scala.collection.mutable.Stack
  val stack = Stack(1, 2, 3)
  stack.push(4) // Adds element 4 to the top of the stack
  println(stack)
  val topElement = stack.pop() // Removes and returns the top element (4)

  println(topElement)

}
