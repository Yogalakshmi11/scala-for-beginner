package concurrency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Future3 extends App{
  case class Users(name:String)
  case class Transaction (userName:String, merchantName : String, amount:Double, status: String)
  object BankingSystem {
    def fetchUser(name:String): Future[Users] = Future{
      Users(name)
    }

    def createTransaction(use:String, merchant:String, cost:Double):Future[Transaction]= Future{
      Thread.sleep(3000)
      Transaction(use, merchant,cost,"SUCESS")
    }


  }
}
