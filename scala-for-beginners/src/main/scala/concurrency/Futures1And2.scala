package concurrency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Futures1And2 extends App{
  val tryFuture1 = Future{
    println("Hello")
  }

  tryFuture1.onComplete{
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  }
  Thread.sleep(1000)
  println(tryFuture1.value)   // it will return an option

//  println(tryFuture1)


  case class Profile(name : String, id : String) {
    def poke(anotherProfile : Profile): Unit ={
      println(s"${this.name} is poking ${anotherProfile.name}")
    }
  }

  object SocialNetwork {
    val names = Map(
      "fb.id.1" -> "Mark",
      "fb.id.2" -> "Daniel",
      "fb.id.0" -> "Dummy"
    )

    val bestFriend = Map(
      "fb.id.1" -> "fb.id.2"
    )

    def fetchBestFriend(id : String) :Future[Profile] = Future{
      val bestFriendId = bestFriend(id)
      val bestFriendName = names(bestFriendId)
      Profile(bestFriendName, bestFriendId)
    }

    def fetchProfile(id :String):Future[Profile] = Future{
      val profilerName = names(id)

      Profile(profilerName, id)
    }


  }

  val mark = SocialNetwork.fetchProfile("fb.id.1")
    mark.onComplete{
    case Success(profileResult) => {
      val bff = SocialNetwork.fetchBestFriend(profileResult.id)
      bff.onComplete {
        case Success(anotherProfileResult) => profileResult.poke(anotherProfileResult)
        case Failure(exception) => println(exception)
      }
    }
    case Failure(exception) => println(exception)

  }
  Thread.sleep(3000)

  for{
    mark <- SocialNetwork.fetchProfile("fb.id.1")
    bff <- SocialNetwork.fetchBestFriend(mark.id)
  } mark.poke(bff)

  Thread.sleep(1000)

  // fallbacks

  val fallBackProfile = SocialNetwork.fetchProfile("Summa"). recover{
    case exception: Exception => Profile("fb.id.0", "Dummay")
  }

  val fallBackWithRecoverWith = SocialNetwork.fetchProfile("Summa").recoverWith{
    case exception: Exception => SocialNetwork.fetchProfile("fb.id.0")
  }

  val fallback = SocialNetwork.fetchProfile("Summa").fallbackTo(SocialNetwork.fetchProfile("fb.id.0"))

  // difference between recover, recoverWith, fallBackTo
  //recover and recoverWith are primarily for handling exceptions and providing alternative results based on those exceptions.
  // recover -> alternative result
  // recoverWith -> alternative Future
  //fallbackTo is for providing an alternative Future to execute if the original Future fails, regardless of the reason for the failure.
  // if the alternative future is also failing in fallBackTo, then it will continue with the actual exception and throws and error.
  
  Thread.sleep(1000)
  println(fallBackProfile)
}
