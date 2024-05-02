//package practice
//
//import scala.collection.mutable
//
//class Book(val title:String, val author : String, val isbn:String, val genre:String, var isAvailable:Boolean)
//
//class Library {
//
//  private val books : mutable.Map[String, Book] = mutable.Map()
//
//  def addBook(book:Book): Unit = {
//    books.put(book.isbn, book)
//  }
//
//  def removeBook(book:Book): Unit = {
//    books.remove(book.isbn)
//  }
//
//  def findBook(isbn:String): Option[Book] = {
//    books.get(isbn)
//  }
//
//  def borrowBook(isbn:String): Option[Book] = {
//    val bookOption = books.get(isbn)
//
//    bookOption.foreach(book=>{
//      if (book.isAvailable){
//        book.isAvailable = false
//      }
//    })
//
//    bookOption
//}
//
//  def returnBook(isbn:String): Unit = {
//    val bookOption = books.get(isbn)
//    bookOption.foreach(book=>{
//      if (book.isAvailable){
//        book.isAvailable = true
//      }
//    })
//  }
//}
//
//class Patron(val name : String){
//   val borrowedBooks : mutable.Set[String] = mutable.Set()
//  def borrowBook(isbn:String): Unit = {
//
//    borrowedBooks.add(isbn)
//  }
//
//  def returnBook(isbn:String): Unit = {
//    borrowedBooks.remove(isbn)
//  }
//}
//
//class ManagementSystem(library : Library){
//
//  def searchBook(isbn: String): Option[Book] = {
//    library.findBook(isbn)
//  }
//
//  def borrowBook(isbn:String, patron: Patron): Unit = {
//    library.findBook(isbn).foreach(book => {
//      println(book.isAvailable)
//      if (book.isAvailable){
//        println(patron)
//        library.borrowBook(isbn)
//        patron.borrowBook(isbn)
//      }
//      else{
//        println("No stock")
//      }
//    })
//
//  }
//
//  def returnBook(isbn:String, patron: Patron): Unit = {
//    library.returnBook(isbn)
//    patron.returnBook(isbn)
//  }
//
//
//}
//
//object LibraryManagement extends App{
//
//  val library = new Library
//
//  val patron1 = new Patron("Joe")
//  val patron2 = new Patron("Rom")
//
//  val libraryManagementSystem = new ManagementSystem(library)
//
//  library.addBook(new Book("Scala Programming", "John Doe", "1234567890", "Programming", true))
//  library.addBook(new Book("Java Basics", "Jane Smith", "0987654321", "Programming", true))
//
//  libraryManagementSystem.borrowBook("1234567890", patron1)
//
//  libraryManagementSystem.borrowBook("1234567890", patron2)
//  println(patron1.borrowedBooks)
//  println(patron2.borrowedBooks)
//
//
//}
