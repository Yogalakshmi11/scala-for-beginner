package concurrency

import java.util.concurrent.{Executor, Executors}

object Intro extends App {
  val aThread = new Thread(new Runnable{

    override def run(): Unit = println("Hi")
  })
//  aThread.start()



  val runnable = new Runnable {
    override def run(): Unit = println("hello")
  }
//  a thread is the smallest unit of process
  // why are we using runnables? -> runnables are used as interface we can separate the task logic from the thread
  // creation logic, promoting better code organization and reusability.

  val threadExample = new Thread(() => (1 to 5).foreach(_=> println("Hello")))
  val threadExample1 = new Thread(() => (1 to 5).foreach(_=> println("hi")))
  threadExample.start()
  threadExample.join()
  threadExample1.start()

  threadExample1.join()
  //different runs produces different results - this is because scheduling, scheduling depends on os and jvm
  // we can solve this problem, and act the thread workings in a predictable way



  //executors - how to reuse the threads by using thread pool and executors
  val pool = Executors.newFixedThreadPool(10)
//  pool.execute(()=> println("Something in the thread pool"))
//  pool.execute(()=>{
//    Thread.sleep(1000)
//    println("First")
//  })
//
//  pool.execute(()=> {
//    Thread.sleep(1000)
//    println("Second")
//    Thread.sleep(500)
//    println("2000 milli second")
//  })
  pool.shutdown()
//  pool.shutdownNow()

  def inception(maxThreads:Int, i : Int =1) : Thread = new Thread (() =>{
    if (i < maxThreads ) {
      val newThread = inception(maxThreads, i+1)
      newThread.start()
      newThread.join()
    }
    println(s"I'm $i")
  })
 inception(50).start()

  var message = ""
  val thread = new Thread(() => {
    Thread.sleep(1000)
    message = "Scala is awesome"
  })

  message = "Scala sucks"
  thread.start()
//  thread.join()
//  Thread.sleep(2000)
  println(message)

  class bankAccount(var account : Int){
    override def toString:String = ""+account
  }
  def buy(account:bankAccount, thing:String, price:Int): Unit = {
    account.synchronized {
      account.account -= price
      println("current balance " + account + " for product " + thing)
    }
  }
////  println(buy(new bankAccount(5000), "car", 500))
//  for (_ <- 1 to 10000){
//    val account = new bankAccount(50000)
//    val newThread = new Thread(() => buy(account, "shoes", 3000))
//    val newThread1 = new Thread(() => buy(account, "Horse", 5000))
//    newThread.start()
////    newThread.join()
//    newThread1.start()
////    newThread.join()
//    Thread.sleep(10)
//    println()
//
//  }
  class Counter {
    private var count = 0

    def increment(): Unit =  synchronized {
      count += 1
    }

    def decrement(): Unit = synchronized {
      count -= 1
    }

    def getCount: Int = synchronized {
      count
    }
  }


    val counter = new Counter

    val thread1 = new Thread(() => {
      for (_ <- 1 to 1000) {
        println("Counter 1", counter.getCount)
        counter.increment()
      }
    })

    val thread2 = new Thread(() => {
      for (_ <- 1 to 1000) {
        println("Counter",counter.getCount)
        counter.decrement()
      }
    })

    thread1.start()
  thread1.join()
    thread2.start()



    thread2.join()
//  println(counter.getCount)
    println("Final count: " + counter.getCount)



}
