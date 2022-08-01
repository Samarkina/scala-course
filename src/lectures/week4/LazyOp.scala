package lectures.week4

object LazyOp extends App {
  val abc = List("A", "B", "C")

  def add(res: String, x: String) = {
    println(s"op: $res + $x = ${res + x}")
    res + x
  }

  val numbers = List(3, 3, 3, 3)
  println(numbers.scanLeft(2)(_ * _))

}
