package concurrency

object NotifyVsNotifyAll extends App{

  def ringRang():Unit= {
    val bell = new Object

    (1 to 10).foreach(i => new Thread (() =>{
      bell.synchronized{
          println(s"Hy I'm waiting $i")
          bell.wait()
          println(s"The bell has been rang by $i")
        }
      }).start())
      new Thread(() => {
        Thread.sleep(200)
        bell.synchronized{

          println("Hurray")
          bell.notifyAll()
        }
      }).start()


  }
//  ringRang()


  def bangBang() : Unit ={
    val jingleBell = new Object
    (0 to 10).foreach(i => new Thread(() => {
      jingleBell.synchronized {
        println(s"Hy I'm $i, I'm waiting for bell to ring!")
        jingleBell.wait()
        println(s"Hy I'm ringing Bro! - by $i")
      }
    }).start())

    new Thread (() =>{
      Thread.sleep(2000)
      jingleBell.synchronized{

        println("Now I'm going to give the notification for all the bells to ring ring!!!")
        jingleBell.notifyAll()
      }
    }).start()
  }

  bangBang()
}
