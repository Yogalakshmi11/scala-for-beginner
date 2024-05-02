package concurrency


import scala.collection.mutable
import scala.util.Random

object Level2 extends App{
  //Producer [. . .] Producer want to fill the container and the capacity of the container is 3
  // Consumer when the container has been started to fill by producer, even if the container contains only one value,
  // The Consumer should remove the latest added element
  // inorder extract the latestily added element we are using the queue here

  def LevelTwo() : Unit = {
    val buffer: mutable.Queue[Int] = mutable.Queue()
    val capacity = 3
    val consumer = new Thread (() => {
      val random = new Random()

        while (true) {
          buffer.synchronized {
            if (buffer.isEmpty) {
              println("buffer is Empty")
              buffer.wait()
            }

            val x = buffer.dequeue()
            println("Consumed -> ", x)
            buffer.notify()
            Thread.sleep(random.nextInt(500))
          }
        }

    })

    val producer = new Thread(() => {
      val random = new Random()
      var i = 0

        while(true) {
          buffer.synchronized{
          if (buffer.size == capacity){
            println("buffer is full")
            buffer.wait()
          }
          buffer.enqueue(i)

          buffer.notify()
          i += 1
          Thread.sleep(random.nextInt(500))
        }

      }
    })

    consumer.start()
    producer.start()
  }
  LevelTwo()

}
