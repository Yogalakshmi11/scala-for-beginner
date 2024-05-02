package concurrencyPractice

import scala.util.Random

object Sum2 extends App{
//  Reader-Writer Problem:
  //Implement the reader-writer problem where multiple reader threads and writer threads access a shared resource concurrently.
  // Use appropriate synchronization techniques to allow multiple readers or a single writer to access the resource at a time.

  class ReaderWriter{
    private var resource = ""
    private var ReaderCounter = 0
    val random = new Random()

    def reader(id:Int): Unit ={
      val bff = new Object
      synchronized{
        ReaderCounter += 1
        //simulate the reading operation
        Thread.sleep(random.nextInt(500))
        // then the reader leaves
        ReaderCounter -= 1
      if (ReaderCounter == 0){
        println("Now all done with reader")

        notify()
      }}
    }

    def writer(id:Int):Unit ={
      synchronized {
        while (ReaderCounter > 0) {
          println(s"I'm Writer $id, waiting to write the book")
          wait()
        }
        val content = s"I'm Writer $id, I'm writing a book!!!"
        println("content", content)
        resource = content
        Thread.sleep(random.nextInt(500))
        notify()
      }
    }


  }

  val ReadWrite = new ReaderWriter()

  val createReader = (1 to 3).map{ id =>
    new Thread(() => {
      for (_ <- 1 to 5){
        ReadWrite.reader(id)
      }
    })
  }

  val createWritter = (1 to 5).map{id =>
    new Thread(() =>{
      for (_ <- 1 to 5){
        ReadWrite.writer(id)
      }
    })
  }

  val aTasks = createReader++createWritter
  aTasks.foreach(x =>{
    x.start()
  })

  aTasks.foreach(y=>{
    y.join()
  })
}
