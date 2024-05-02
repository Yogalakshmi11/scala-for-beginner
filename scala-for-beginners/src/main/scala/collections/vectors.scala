package collections

object vectors extends App{
  val vec1 = Vector(1, 2, 3) // Creating a vector using the companion object
  val vec2 = Vector.empty[String] // Creating an empty vector of strings
  val vec3 = Vector.tabulate(5)(_ * 2) // Creating a vector of 5 elements using a function
  println(vec3)

}
