package practice.OnlineClassSystem

import scala.collection.mutable


class Course(val name:String, val courseCode : String, val dept: String, val lectureName : String)

class Unacademy{

  private val courses : mutable.Map[String, Course] = mutable.Map()
  def addCourse(course: Course):Unit = {
    courses.put(course.courseCode,course)
  }
  def removeCourse(courseCode : String):Unit ={
    courses.remove(courseCode)
  }
  def findCourse(courseCode:String): Option[Course] = {
    courses.get(courseCode)
  }


  //// overloading ////
  def listCourses(lectureName:String): Unit={
    courses.foreach(course =>{
      if (lectureName == course._2.lectureName) {
        println(f"Course Name -> ${course._2.name}, Course Code -> ${course._2.courseCode}, Dept Name -> ${course._2.dept}")
      }
    })
  }

  def listCourses : Unit = {
    courses.foreach(course =>{
      println(f"Course Name -> ${course._2.name}, Course Code -> ${course._2.courseCode}, Dept Name -> ${course._2.dept}")
    })
  }
  //// overloading ////

}

//// inheritance ////
class Student(val name : String) extends Unacademy {
  def viewCourse: Unit = {
    listCourses
  }
}


//// inheritance ////
class Lecture(val name : String) extends Unacademy {
  private val lectureCourses : mutable.Map[String, Course] = mutable.Map()
  def addNewCourse(course: Course):Unit = {
    lectureCourses.put(course.courseCode,course)
    addCourse(course)
  }
  def removeLectureCourse(courseCode : String):Unit ={
    lectureCourses.remove(courseCode)
    removeCourse(courseCode)
  }
  def viewCourse: Unit = {
    listCourses(name)
  }
}


//// inheritance, polymorphism

object OnlineClassSystem extends App{
  val student = new Student("Jow")
  val lecture = new Lecture("Roy")

  val academy = new Unacademy
  val course1 = new Course("Scala Programming", "123456789", "CS", "Roy")
  val course2 = new Course("Python Programming", "987654321", "CS", "Daniel")
  academy.addCourse(course2)
//  academy.listCourses
  lecture.addNewCourse(course1)
  lecture.viewCourse
  student.viewCourse
}
