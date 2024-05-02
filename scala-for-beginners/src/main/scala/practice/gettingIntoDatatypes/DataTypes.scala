package practice.gettingIntoDatatypes

object DataTypes {

}
import scala.io.Source

//object FileTypeDetector {
//  def isBinaryFile(filePath: String): Boolean = {
//    val fileContent = Source.fromFile(filePath).take(1024).toArray // Read the first 1024 bytes
//    val nullBytesCount = fileContent.count(_ == 0) // Count null bytes
//    val nonPrintableAsciiCount = fileContent.count(b => b < 32 && b != 9 && b != 10 && b != 13) // Count non-printable ASCII characters
//
//    val totalBytes = fileContent.length
//    val binaryThreshold = 0.1 // Threshold for considering the file as binary (adjust as needed)
//
//    // If the file contains a high proportion of null bytes or non-printable ASCII characters, it's likely binary
//    (nullBytesCount.toDouble / totalBytes > binaryThreshold) || (nonPrintableAsciiCount.toDouble / totalBytes > binaryThreshold)
//  }
//
//  def main(args: Array[String]): Unit = {
//    val filePath = "/home/yogalakshmir/Pictures/remmina_Quick Connect_10.0.1.91_20240208-023312.png"
//    if (isBinaryFile(filePath)) {
//      println("The file is binary.")
//    } else {
//      println("The file is not binary.")
//    }
//  }
//}
import java.nio.file.{Files, Paths}

//object FileTypeDetector {
//  def isTextFile(filePath: String): Boolean = {
//    val bytes = Files.readAllBytes(Paths.get(filePath))
//    val isText = bytes.forall(byte => byte >= 9 && byte <= 126 && byte != 11 && byte != 12) // Check if all bytes are within the printable ASCII range
//    bytes.foreach(byte => println(byte))
//    return isText
//  }
//
//  def main(args: Array[String]): Unit = {
//    val filePath = "/home/yogalakshmir/Projects/Adhoc/web_scraping/fakerA.py"
//    if (isTextFile(filePath)) {
//      println("The file is a text file.")
//    } else {
//      println("The file is not a text file.")
//    }
//  }
//}
import java.nio.file.{Files, Paths}

object FileTypeDetector {
  def isTextFile(filePath: String): Boolean = {
    val bytes = Files.readAllBytes(Paths.get(filePath))
    val isText = bytes.forall { byte =>
      byte >= 9 && byte <= 126  // Check if byte falls within printable ASCII range or common range for extended characters

    }
    isText
  }

  def main(args: Array[String]): Unit = {
    val filePath = "/home/yogalakshmir/Projects/TankerProject/logback.xml"
    if (isTextFile(filePath)) {
      println("The file is a text file.")
    } else {
      println("The file is not a text file.")
    }
  }
}
