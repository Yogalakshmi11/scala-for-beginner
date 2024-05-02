package practice.OnlineShoppingSystem

import scala.collection.mutable

//Product Class: Create a Product class to represent each product available for purchase.
// Each product should have attributes such as name, description, price, and quantity available.
class Product(val name:String, val description:String, val productCode : String,val price:String, var quantity:Int)

class Stock{
  private val products : mutable.Map[String, Product] = mutable.Map()
  def addProductsBySeller(product: Product): Unit = {
    products.put(product.productCode, product)
  }
  def reduceProductStockAsPerSelling(productCode : String): Unit = {
    val product = products.get(productCode)

    product.foreach(prod =>{
      if (prod.quantity == 0){
        products.remove(productCode)
      }
      else{
        prod.quantity -= 1
      }
    })
  }
  def removeProduct(productCode : String): Unit ={
    products.remove(productCode)
  }
  def showCase: Unit = {
    products.foreach(prod=>{
      println(prod._2.name)
    })
  }

  def findProduct(productCode : String):Option[Product]={
    products.get(productCode)
  }

  def isProductAvailable(productCode:String):Boolean ={
    val product = products.get(productCode)
    var productAvailable = false
    product.foreach { prod => {
      if (prod.quantity == 0) {
        productAvailable = false
      }
      else {
        productAvailable = true
      }
    }
    }
    productAvailable
  }
}



//Shopping Cart Class: Implement a ShoppingCart class to represent the shopping cart of each user.
// The shopping cart should contain methods to add products, remove products, view the contents of the cart, and calculate the total price.

class shoppingCart(stock: Stock){
  private val shoppingCart : mutable.Map[String , Option[Product]] = mutable.Map()
  def addProducts(productCode : String): Unit = {
    if (stock.isProductAvailable(productCode)){
      val product = stock.findProduct(productCode)
      shoppingCart.put(productCode, product)
    }
  }

  def removeProducts(productCode:String)={
    shoppingCart.remove(productCode)
  }

  def showCase : Unit = {
    shoppingCart.foreach(item =>{
      item._2.foreach(it =>{
        println(it.name)
      })
    })
  }


//  def totalCost() : Int ={
//    val totalCost = {
//      shoppingCart.foreach
//    }
//
//    totalCost
//  }

}

//User Class: Define a User class to represent each user of the online shopping system.
// Each user should have attributes such as name, email, shipping address, and a shopping cart.
class User(val name : String, stock: Stock){
  val cart:shoppingCart =  new shoppingCart(stock)
  def shoppingCart(productCode:String) : Unit = {
    cart.addProducts(productCode)
  }
  def removeProducts(productCode:String): Unit = {
    cart.removeProducts(productCode)
  }

  def viewCart(): Unit = {
    cart.showCase
  }
}

object OnlineShoppingSystem extends App{

  val stock = new Stock
  val product1 = new Product("kurti", "Nothing", "123456", "100",8)
  val product2 = new Product("jean", "Nothing", "654321", "100",8)
  stock.addProductsBySeller(product1)
  stock.addProductsBySeller(product2)

  val user1 = new User("Yoga", stock)
  val user2 = new User("Pavii", stock)
  user1.shoppingCart("123456")
  user2.shoppingCart("654321")
  user2.viewCart()
  user1.viewCart()
  stock.showCase
}



