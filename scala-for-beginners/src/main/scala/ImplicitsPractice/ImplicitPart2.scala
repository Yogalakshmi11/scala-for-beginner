package ImplicitsPractice

object ImplicitPart2 extends App {


  implicit def descending: Ordering[Int] = Ordering.fromLessThan(_>_)
  println(List(1,3,4,5,2).sorted)

  // Implicits
  // val
  // var
  // object
  // def without (), without parameters

  case class Person (name : String, age : Int)

  val sortedCaseClass = List (
    Person ("Amy", 90),
    Person("Temy", 20),
    Person("Kemy", 34)
  )

//  implicit def descendingOrder : Ordering[Person] = Ordering.fromLessThan(_.age > _.age)


//  implicit def alphabetAscending : Ordering[Person] = Ordering.fromLessThan((a,b) => {
//    println( a.name.compareTo(b.name))
//    a.name.compareTo(b.name) < 0
//  })
//  println(sortedCaseClass.sorted)

  // Implicits Scope
  // Normal Scope -> Local Scope
  // Imported Scope -> what we have did in Futures
  // Companions of all type involved in the method signature


  // for a single case class Person , we have two types of sorting
  // sort by name and sort by age
  // so we can keep those implicits inside the objects separately
  // we will import those


  object AlphabeticNameOrdering {
    implicit val NameOrdering : Ordering[Person] = Ordering.fromLessThan((a,b) => a.name.compareTo(b.name) < 0)
  }

  object AgeOrdering {
    implicit val AgeOrdering1 : Ordering[Person] = Ordering.fromLessThan(_.age < _.age)
  }

  // by importing , we can you the required implicits

  import AlphabeticNameOrdering.NameOrdering
  println(sortedCaseClass.sorted)

  case class Purchase (nUnits : Int, pricePerUnit : Double)

//  implicit val UnitCount : Ordering[Purchase] = Ordering.fromLessThan((a,b) => a.nUnits < b.nUnits)
//  implicit val UnitPrice : Ordering[Purchase] = Ordering.fromLessThan((a,b) => a.pricePerUnit < b.pricePerUnit)

  // total price ordering is most used ordering - 50%
  // Unit Count - 25%
  // Unit Price - 25%

  // so as we see total price's weightage is high when compared to others, so inorder to access it fastly, we will create a
  // companion object

  object Purchase{
    implicit val TotalPrice : Ordering[Purchase]  = Ordering.fromLessThan((a, b) => a.nUnits*a.pricePerUnit < b.nUnits*b.pricePerUnit)
  }

  val listOfPurchase = List(
    Purchase(9, 80),
    Purchase(2, 69),
    Purchase(1, 10)
  )


  println(listOfPurchase.sorted)




}
