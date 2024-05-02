package concurrency

object DeadLock extends App{
  val deadLock1 = new Object
  val deadLock2 = new Object
  val thread1 = new Thread(() => {
    deadLock1.synchronized{
      Thread.sleep(100)
      println("Lock 1")
    }
  })

  val thread2 = new Thread(()=>{
    deadLock2.synchronized{
      Thread.sleep(100)
      println("Lock 2")
    }
  })

  thread1.start()
  thread2.start()
}
