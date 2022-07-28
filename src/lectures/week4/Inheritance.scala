package lectures.week4

object Inheritance extends App {
  trait Printer {
    def print: Unit
  }

  trait PrintInRed extends Printer {
    override def print: Unit = println("text in red")
  }

  trait PrintInBlue extends Printer {
    override def print: Unit = println("text in blue")
  }

  class PrintInColor extends PrintInRed with PrintInBlue

  val colorPrinter = new PrintInColor
  colorPrinter.print

}
