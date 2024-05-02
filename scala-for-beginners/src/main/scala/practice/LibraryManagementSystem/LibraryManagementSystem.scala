package practice

import scala.collection.mutable


class Book(val title:String, val author :String, val isbn : String, var isAvailable : Boolean)



class Library{
  val books : mutable.Map[String, Book] = mutable.Map()

  def addBook(book : Book): Unit = {
    books.put(book.isbn, book)
  }

  def removeBook(isbn : String): Unit = {
    books.remove(isbn)
  }

  def findBook(isbn : String) : Option[Book] = {
    books.get(isbn)
  }

  def borrowBook(isbn:String) : Option[Book] ={
    val bookOption = books.get(isbn)
    bookOption.foreach(book=>{
      if (book.isAvailable){
        book.isAvailable = false
      }
    })

    bookOption
  }
}

class Patron {
  val borrowedBooks : mutable.Set[String] = mutable.Set()
  def borrowBooks(isbn : String): Unit = {
    borrowedBooks.add(isbn)
  }

  def removeBooks(isbn: String) : Unit ={
    borrowedBooks.remove(isbn)
  }
}

class ManagementSystem(library: Library){
  def searchBooks(isbn:String): Option[Book] = {
    library.findBook(isbn)
  }

  def borrowBooks(isbn:String, patron: Patron): Unit = {
    val searchedBook =  library.findBook(isbn)
    searchedBook.foreach(book => {
      if (book.isAvailable){
        library.borrowBook(isbn)
        patron.borrowBooks(isbn)
      }

      else {
        println("No stock")
      }
    })

  }

  def removeBooks(isbn:String, patron: Patron): Unit = {
    library.removeBook(isbn)
    patron.removeBooks(isbn)
  }
}


object LibraryManagementSystem extends App{

  val library = new Library

  library.addBook(new Book("Scala Programming", "John Doe", "1234567890", true))
  library.addBook(new Book("Java Basics", "Jane Smith", "0987654321", true))

  val patron1 = new Patron
  val patron2 = new Patron

  val libraryManagementSystem = new ManagementSystem(library)
  libraryManagementSystem.borrowBooks("1234567890", patron1)
  libraryManagementSystem.borrowBooks("1234567890", patron2)


  println(patron1.borrowedBooks)
  println(patron2.borrowedBooks)
}
