package lectures.week3fp

object patterns extends App {
  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of integers"
    case _ => "default case"
  }

  println(numbersMatch)

}
