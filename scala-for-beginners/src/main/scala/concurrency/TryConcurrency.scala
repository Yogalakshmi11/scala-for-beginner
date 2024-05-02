package concurrency

object TryConcurrency extends App{

//  //synchronized , we should not use at the initialization of a variable, we should use at the code block
//  var value =  200
//  val thread1 = new Thread(() => {
//    synchronized {
//      println("Thread1", value)
//      value += 300
//    }
//  }
//  )
//
//  val thread2 = new Thread(() => {
//    synchronized {
//      //    Thread.sleep(200)
//      println("Thread2", value)
//      value -= 100
//    }
//  })
//
//  thread1.start()
//  thread2.start()
////  Thread.sleep(300)
//  println()
//
//  // use of join() It's commonly used when you need the main thread to wait for other threads to finish their tasks.
//  // By calling join() on a thread object, the main thread will block until the specified thread completes.
//  // This is useful when you need the results or side effects of other threads before continuing
//  // with the main thread's execution.
//  thread1.join()
//  thread2.join()
//  println(value)


  class syn{
    private var value1 = 0
    def incrementer:Int = {
      value1 += 1
      value1
    }
    def decrementer:Int =  {
      value1 -= 1
      value1
    }

    def getValue:Int ={
      value1
    }
  }

  val trySyn = new syn

  val threadV1 = new Thread(()=>synchronized{
    for (_ <- 1 to 100000) {
      trySyn.incrementer
    }
  })
  val threadV2 = new Thread(()=>synchronized{

    for (_ <- 1 to 50000) {

      trySyn.decrementer
    }
  })
//  threadV1.start()
//  threadV2.start()
//  threadV1.join()
//  threadV2.join()
//
//  println("synValue",trySyn.getValue)
//
//  var value = 0
//
//  val threadV3 = new Thread(()=>{
//    while (value == 0){
//      println("I'm Waiting")
//    }
//    value -=50
//  })
//  val threadV4 = new Thread(()=>{
//    Thread.sleep(100)
//    value = 100
//  })
//  threadV3.start()
//  threadV4.start()
//  threadV3.join()
//  threadV4.join()
//  println(value)

  class simpleContainer{
     private var value = 0
    def isEmpty : Boolean = value == 0
    def set(n:Int) :Int={
      value = n
      value
    }
    def get:Int={
      val result = value
      value = 0
      result
    }
  }


  val container = new simpleContainer
  val threadCon = new Thread(()=> {
    container.synchronized {
      container.wait()
//      container.get
      println("I'm waiting")
      container.set(container.get - 5)
    }
  })

  val threadCon1 = new Thread(() => {
    container.synchronized {
      container.set(9)
      container.notify()
    }
  })

  threadCon.start()
  threadCon1.start()
  threadCon.join()
  threadCon1.join()

  println(container.get)

}
