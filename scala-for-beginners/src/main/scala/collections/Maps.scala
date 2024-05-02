package collections

object Maps extends App{

  val keyList = List("Apple", "Orange", "Mango", "Banana")
  val valueList = List(100, 150, 123, 140)

  val keyValuePair = keyList.zip(valueList).toMap

  val keyCollections = keyValuePair.keySet.toList
  val valueCollections = keyValuePair.values.toList

  println(keyValuePair.getOrElse("Strawberry", "no cost"))
  val getStrawberry = keyValuePair.get("Starwberry") match{
    case Some(value) => value.toString
    case None => "no cost for strawberry"
  }
  println(getStrawberry)
}
