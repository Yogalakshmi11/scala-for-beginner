package TypeClass

import java.util.Date

object TypleCLass1 extends App{

  case class User (name : String, age : Int)
  trait HTMLSerializer[T]{
    def serializer(value : T) : String
  }

  object UserSerializer extends HTMLSerializer[User]{
    def serializer(user :User) = s"My name is ${user.name}"
  }
  object DateSerializer extends HTMLSerializer[Date] {
     def serializer(date: Date): String = s"${date.toString}"
  }

  // so here instead of using Any -> from scala, we are using T
//  Difference:
  //
  //The main difference between T and Any is that T is a type parameter that represents a specific, possibly unknown type determined by the context or type constraints, while Any is a type that can represent any object or value in Scala.
  //When you define a method with def serialize(value: T), you are saying that the method can accept values of any type, but the actual type will be determined based on the context or type constraints. This allows you to write generic methods that work with multiple types.
  //On the other hand, when you define a method with def serialize(value: Any), you are saying that the method can accept values of any type, without any constraints on the type. This is less type-safe compared to using T, as it allows for any type to be passed to the method, potentially leading to runtime errors if the wrong type is provided.

  /*
  * Exercise
  * */

  trait equality[T]{
    def isEqual(a:T, b:T) :Boolean
  }

  object isNameEqual extends equality[User]{
    override def isEqual(a: User, b: User): Boolean = a.name == b.name
  }

  object HTMLSerializer {
    def serializer[T](value: T)(implicit serializer: HTMLSerializer[T]): String = {
      serializer.serializer(value)
    }
  }
  implicit object IntSerializer extends HTMLSerializer[Int]{
    override def serializer(value: Int): String = "I'm a Int"
  }

  implicit object UserInitializer extends HTMLSerializer[User]{
    override def serializer(value: User): String = "Hy  I'm from User"
  }
  println(HTMLSerializer.serializer(43))
  println(HTMLSerializer.serializer(User("yoga", 23)))


  trait equalizer[T]{
    def apply(a : T, b:T) : Boolean
  }

  object equalizer {
    def apply[T](a: T, b:T)(implicit equalizer: equalizer[T]): Boolean = {
      equalizer.apply(a, b)
    }
  }

  implicit object UserEqualizer extends equalizer[User]{
    override def apply(a: User, b:User): Boolean = a.name == b.name
  }

//   object UserEqualizer extends equalizer[User]{
//    override def apply(a: User, b:User): Boolean = a.name == b.name
//  }


  val john = User("John", 23)
  val anotherJohn = User("John", 34)
  println(UserEqualizer.apply(john, anotherJohn ))
}
