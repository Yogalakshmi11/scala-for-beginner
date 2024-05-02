package Recap

object RecapTypeClass extends App{

  trait htmlSerializer[T]{
    def serailize(value : T) : String
  }

  case class User(name : String, age : Int)

  object UserSerializer extends htmlSerializer[User] {
    override def serailize(user: User): String = s"${user.name} (${user.age})"
  }

  import java.util.Date

  object DateSerializer extends htmlSerializer[Date] {
    override def serailize(date: Date): String = s"${date.toString}"
  }
  println(UserSerializer.serailize(User("John", 32)))
  // so here we are having one single trait, which consumes T, which can used for all the types by instantiating with one
  // singleton object and extending the trait with the type
  // why are we using objects here, it is ease of use, there is no need to instantiate since it is specifically for one object

  // part - 2
  // creating the trait
  // creating the companion object for the trait
  // creating/ implementing the abstract method of the trait

  object htmlSerializer{
    def apply[T](value : T)(implicit serializer: htmlSerializer[T]): Unit = {
      serializer.serailize(value)
    }
  }

  // implementing the abstract method of the trait

  implicit object IntSerilaizer extends htmlSerializer[Int] {
    override def serailize(int: Int): String = int.toString
  }
  // we can use like this IntSerilaizer.serailize(42), but we are ding this in implicit way, we can have many implicit but the compiler able to
  // found that and give the correct implicit to that
  println(htmlSerializer(90))
  // this htmlSerializer companion object is generic to all the types, we should implement the implicits for every types,
  // and we can this single object htmlSerializer everywhere
  // let's think about this
  // StringSerializer.serialize("Hello") to htmlSerializer("Hello")
  // IntSerilaizer.serailize(42) to htmlSerializer(90)

  // as you can see we are using the single object for all the types.





}
