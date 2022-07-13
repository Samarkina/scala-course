package lectures.week3fp

object currying extends App {
  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val res = someFunc(1)
  println(res)

  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala"))
  println(sampleTuple.copy(_2 = "Scala").swap)
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)

  val someVal = Some(2)
  println(someVal.map(_ * 2))
}
