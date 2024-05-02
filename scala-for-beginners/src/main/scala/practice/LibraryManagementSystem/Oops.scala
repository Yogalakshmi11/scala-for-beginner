//package practice
//
//import scala.collection.mutable
//
//// Book class to represent each book in the library
//class Book(val title: String, val author: String, val isbn: String, val genre: String, var isAvailable: Boolean = true)
//
//// Library class to manage the collection of books
//class Library {
//  private val books: mutable.Map[String, Book] = mutable.Map()
//  println(books.toList)
//  def addBook(book: Book): Unit = {
//    books.put(book.isbn, book)
//  }
//
//  def removeBook(isbn: String): Unit = {
//    books.remove(isbn)
//  }
//
//  def findBook(isbn: String): Option[Book] = {
//    books.get(isbn)
//  }
//
//  def borrowBook(isbn: String): Option[Book] = {
//    val bookOption = books.get(isbn)
//    println(bookOption.foreach { book => println(book)})
//    bookOption.foreach { book =>
//      if (book.isAvailable) {
//        book.isAvailable = false
//      }
//    }
//    bookOption
//  }
//
//  def returnBook(isbn: String): Unit = {
//    books.get(isbn).foreach(_.isAvailable = true)
//  }
//}
//
//// Patron class to represent library patrons
//class Patron(val name: String, val libraryCardNumber: String) {
//   val borrowedBooks: mutable.Set[String] = mutable.Set()
//
//  def borrowBook(isbn: String): Unit = {
//    borrowedBooks.add(isbn)
//  }
//
//  def returnBook(isbn: String): Unit = {
//    borrowedBooks.remove(isbn)
//  }
//}
//
//// LibraryManagementSystem class to serve as the main interface
//class LibraryManagementSystem(library: Library) {
//  def searchBook(isbn: String): Option[Book] = {
//    library.findBook(isbn)
//  }
//
//  def borrowBook(isbn: String, patron: Patron): Option[Book] = {
//    val bookOption = library.borrowBook(isbn)
//    bookOption.foreach(_ => patron.borrowBook(isbn))
//    bookOption
//  }
//
//  def returnBook(isbn: String, patron: Patron): Unit = {
//    library.returnBook(isbn)
//    patron.returnBook(isbn)
//  }
//}
//
//// Example usage
//object Main extends App {
//  val library = new Library()
//  val book1 = new Book("Scala Programming", "John Doe", "1234567890", "Programming")
//  val book2 = new Book("Java Basics", "Jane Smith", "0987654321", "Programming")
//  library.addBook(book1)
//  library.addBook(book2)
//
//  val patron1 = new Patron("Alice", "001")
//  val patron2 = new Patron("Bob", "002")
//
//  val librarySystem = new LibraryManagementSystem(library)
//
//  // Patron 1 borrows a book
//  librarySystem.borrowBook("1234567890", patron1)
//  println("Patron 1 borrowed Scala Programming")
//  println(patron1.borrowedBooks)
//
//  // Patron 2 tries to borrow the same book
//  librarySystem.borrowBook("1234567890", patron2)
//  println("Patron 2 tried to borrow Scala Programming")
//  println(patron2.borrowedBooks)
//
//  // Patron 1 returns the book
//  librarySystem.returnBook("1234567890", patron1)
//  println("Patron 1 returned Scala Programming")
//}
