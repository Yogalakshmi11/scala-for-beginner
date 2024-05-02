package concurrencyPractice

import scala.collection.mutable

object Sum3 extends App{

  val buffer : mutable.Queue[Int]= mutable.Queue()
  val capacity = 3

  val producer = new Thread (() =>{
    synchronized{
      while(buffer.size == capacity){
        println("Hy I'm waiting here because of the buffer size")
        wait()
      }
      buffer.enqueue(1)
    }
  })


}
