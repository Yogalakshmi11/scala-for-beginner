package practice.HandlingOptions




object Options extends App{

  val number : Option[Int] = None
  val number1 : Option[String] = Some("Hello")

  // use match

 number match{
   case Some(x) => println(x)
   case None => println("I'm None")
 }

  // get or else

  val getOrElseCheck = number.getOrElse(0)

  println(getOrElseCheck)

  // map

  val mapCheck = number.map(_+1)
  println(mapCheck)

  // flatmap

  val flatMapCheck = number.flatMap(x => Some(x+2))
  println(flatMapCheck)

  // filter

  val filterCheck = number.filter(x => x != 1)
  println(filterCheck)

  // exists

  val existCheck = number.exists(x => x > 4)

  println(existCheck)

  // fold

  val foldCheck = number.fold(0)(x=> x*2)
  println(foldCheck)

  val forComprehensionCheck = for {
    x <- number
  } yield x

  println(forComprehensionCheck)



 // In order to handle Option we have match case, getOrElse, fold -> we can set the default value
  // without default value -> map, flatmap, foreach, for comprehension, filter, exists
}
