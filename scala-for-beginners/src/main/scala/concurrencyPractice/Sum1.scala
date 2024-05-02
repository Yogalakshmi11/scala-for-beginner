package concurrencyPractice

import scala.collection.mutable
import java.util.concurrent.locks.ReentrantLock
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
object Sum1  extends App{

  val producerCount = 3
  val consumerCount = 2
  val capacityOfBuffer = 10
  val Buffer:mutable.Queue[Int] = mutable.Queue()
  val lock = new ReentrantLock()

  def producer(id:Int)={

    for(i <- 1 to 10){
      Thread.sleep(1000)
      val item = id+i
      println("ID", id)
      println(item)
      lock.lock()
      try{
        while (Buffer.size >= capacityOfBuffer) {
          println(s"Hy I'm producer, My Id is $id, seems like buffer is full")
          lock.newCondition().await()
        }
        Buffer.enqueue(item)
        val x = item
        println(s"Produced -> $x")
        lock.newCondition().signalAll()
      }
      finally {
        lock.unlock()
      }


    }
  }

  def consumer(id:Int)={
    for (i<- 1 to 10){
      Thread.sleep(1500)
      lock.lock()
      try{
        while (Buffer.isEmpty) {
          println(s"Hy I'm Consumer, My id is $id, seems like buffer is empty")
          lock.newCondition().await()
        }

        val x = Buffer.dequeue()
        println(s"Consumed -> $x")
        lock.newCondition().signalAll()
      }
      finally {
        lock.unlock()
      }

    }
  }

  val producerWork = (0 to producerCount).map( i => Future{producer(i)})
  val consumerWork = (0 to consumerCount).map(i => Future{consumer(i)})
  Thread.sleep(6000)
  val allTask = producerWork ++ consumerWork
  Future.sequence(allTask).onComplete({
    case Success(value) => println(value)
    case Failure(exception) => exception
  })
//  println(Buffer)


}
