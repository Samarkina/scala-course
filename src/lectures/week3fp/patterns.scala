package lectures.week3fp

object patterns extends App {
  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of integers"
    case _ => "default case"
  }

  println(numbersMatch)

  for (i <- 1 to 5) {
    i match {
      case i if (i % 2 == 1) => println(s"$i - нечетное число")
      case i if (i % 2 == 0) => println(s"$i - четное число")
    }
  }

}
