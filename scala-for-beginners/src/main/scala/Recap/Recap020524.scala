package Recap

object Recap020524 extends App{


  // concepts studied today

  // 1
  // type system recall
  // type class
  // implicits

  trait HTMLSerializer[T]{
    def serializer(value : T) : String
    def getname = "yoga"
  }

  case class User (name : String, age : Int)

  object UserSerializer extends HTMLSerializer[User]{
    override def serializer(user: User): String = f"${user.name} and ${user.age}"
  }
  val john = User("John", 43)
  // we can do like this
//  UserSerializer.serializer(john)

  // creating the companion object
  object HTMLSerializer{
    def serializer[T](value : T)(implicit serializer : HTMLSerializer[T]): Unit = {
      serializer.serializer(value)
    }

    // apply method to access all the methods

    def apply[T](value : T)(implicit serializer: HTMLSerializer[T])= serializer
  }


  HTMLSerializer.serializer(john)(UserSerializer) // instead of giving UserSerializer explicitily,
  // we can us implicit

  implicit object UserSerializer1 extends HTMLSerializer[User]{
    override def serializer(user: User): String = f"${user.name} and ${user.age}"


  }

  HTMLSerializer.serializer(john) // here we just passing the user entity
  HTMLSerializer.apply(john).getname // as you see, with the apply method, we can access all the methods like getname




  import java.util.Date

  implicit object DateSerializer extends HTMLSerializer[Date] {
    override def serializer(date: Date): String = s"$date"
  }

  HTMLSerializer.serializer(Date)


  // so here by using T we can use the same method, trait, class for all the types

  // RICHINT

   implicit class RichInt(value : Int) {
      def isEven : Boolean = value%2==0
  }

  42.isEven





  // 2
  // Inheritance
  // diamond problem
  // super problem


 // diamond problem
  trait Animal {
    def name : String
  }
  trait Lion extends Animal{
    override def name = "Lion"
  }

  trait Tiger extends Animal{
    override def name: String = "Tiger"
  }


  class checkInheritance extends Animal with Lion with Tiger{
    println(name)
  }
  // last override name will be the output



  // 3
  // variance
  // - covariance
  // - invariance
  // - contravariance


  



}
