package CookbookRecipes

object StringOps extends App {

  val sampleString: String = "Hy I am Sample String"

  // this String uses the classes of Java String as Scala String Methods
  // Java String Methods like Length, string concatenation

  println(sampleString.length)
  println("Just for checking teh concatenation" + sampleString)

  // foreach and for loop
  sampleString.foreach(println)
  for (c <- sampleString) println(c)

  val filterExample = sampleString.filter(_ == 'a')
  println(filterExample)
  val mapExample = sampleString.map(_.toLower)
  println(mapExample)


  def convertToBytes(character: Char): Int = {
    character.toByte
  }

  val mapExampleFunc = sampleString.map(convertToBytes)
  println(mapExampleFunc)
  // here mapping string to get teh output in vector format
  // not only string to string but also string to any types


  val drop = sampleString.drop(2)
  println(drop)

  val take = sampleString.take(6)
  println(take)

  def squareIt(inputNum:Int )={
    inputNum*2
  }


  println(Array(1,2,3,4,5,6,7,8).map(squareIt).toList)

  val squaredNumbers = Array(1,2,2,3,4).map(num => num * num).toList
  println(squaredNumbers)


  val onlyOdd = Array(1,2,3,4,5,6,7,8).filter(num => num % 2 != 0).toList

  println(onlyOdd)


  val mapCheck = List(1,2,3,4,5).map(num => num*num)
  println(mapCheck)

  val flatMapCHeck = List(1,2,3,4,5).flatMap(num => List(num, num*num))
  println(flatMapCHeck)

  val reduceCheck = List(1, 2, 3, 4, 5, 6, 7, 8, 9).reduceLeft((x,y) => x-y)
  println(reduceCheck)
  val reduceCheck1 = List(1,2,3,4,5,6,7,8,9).reduceRight((x,y)=>x-y)
  println(reduceCheck1)

  val groupNumber = List(1,2,3,4,5,6,7,8).grouped(2).map(pair => pair.reduceLeft(_+_)).toList
  println(groupNumber)
  print(groupNumber.reduceRight((x,y)=> {
    println(x,y)
    x - y
  }))

  val slidingNumbers = List(1,2,3,4,5,6,7,8).sliding(2,3).map(pair => pair.reduceLeft(_+_))
  println(slidingNumbers)


  // difference between reduce and reduce left

  val reduce = List(1,2,3,4,5).reduce(_-_)
  print(reduce)


  val reduceLeft = List(1,2,3,4,5).reduceLeft(_-_)
  println(reduceLeft)


  // both reduce and reduce left starting from the left most element
  // reduce right starting from the right most element

  val manyTypesInOneList = List("a",1, true)
  println(manyTypesInOneList.head)
  val manyTypesInOneArray = Array("1",1).toList
  println(manyTypesInOneArray)


}