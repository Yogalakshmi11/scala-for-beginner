package Recap

import scala.collection.mutable

object RecapOopsExercise extends App{

  // LIBRARY MANAGEMENT SYSTEM


  class Book (val Title : String, val Author : String, val isbn : String, var isAvailable : Boolean)

  class Library{
    val books : mutable.Map[String, Book] = mutable.Map()
    def addBook(book:Book): Unit = {

      books.put(book.isbn, book)

    }
    def removeBook (isbn: String): Unit = {
      books.remove(isbn)
    }

    def findBook(isbn: String): Option[Book] = {
      books.get(isbn)
    }

    def borrowBook(isbn: String) : Option[Book] ={
      val bookOption = books.get(isbn)
      bookOption.foreach(book =>{
        if (book.isAvailable){
          book.isAvailable = false
        }
      })
      bookOption
    }
  }

  class Patron{
    val borrowedBooks : mutable.Set[String] = mutable.Set()
    def borrowBook(isbn:String): Unit = {
      borrowedBooks.add(isbn)
    }

    def removeBook (isbn:String): Unit = {
      borrowedBooks.remove(isbn)
    }
  }

  class LibraryManagement(library: Library){
    def searchBook(isbn:String): Option[Book] = {

      library.findBook(isbn)
    }

    def borrowBook(isbn:String, patron: Patron): Unit = {
      val bookOption = library.findBook(isbn)
      bookOption.foreach(book =>{
        if (book.isAvailable){
          library.borrowBook(isbn)
          patron.borrowBook(isbn)
        }
        else println("No Stocks")
      })

    }

    def removeBook(isbn:String, patron: Patron): Unit = {
      library.removeBook(isbn)
      library.removeBook(isbn)
    }
  }


  val library = new Library
  val book1 = library.addBook(new Book("Scala Programming", "John Doe", "1234567890", true))
  val book2 = library.addBook(new Book ("Java Basics", "Jane Smith", "0987654321", true))
  val patron1 = new Patron
  val patron2 = new Patron
  val libraryManagement = new LibraryManagement(library)
  libraryManagement.borrowBook("1234567890", patron1)
  libraryManagement.borrowBook("0987654321", patron2)

  libraryManagement.removeBook("1234567890", patron1)

}
