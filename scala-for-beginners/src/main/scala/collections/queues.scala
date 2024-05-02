package collections

object queues extends App{

  import scala.collection.mutable.Queue
  val queue = Queue(1, 2, 3)
  queue.enqueue(4) // Adds element 4 to the end of the queue
  val frontElement = queue.dequeue() // Removes and returns the front element (1)
  println(frontElement)

}
