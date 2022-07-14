package playground

import scala.util.matching.Regex

object patternTask2 extends App {
  val nameSurname = "John Doe"
  val pattern = """(^\w+\s\w+)""".r
  nameSurname match {
    case pattern(words) => {
      val result = words.split(" ").flatMap(_.headOption).mkString
      print(s"${result(0)}. ${result(1)}.")
    }
    case _ => println(s"Oops, something is wrong")
  }

}