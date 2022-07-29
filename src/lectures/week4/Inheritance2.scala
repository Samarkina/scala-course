package lectures.week4

object Inheritance2 extends App {
  trait Customer {
    def print: Unit = println("customer")
  }

  trait Boss {
    def print: Unit = println("boss")
  }

  trait Employee extends Boss {
    override def print: Unit = {
      println("employee")
      super.print
    }
  }

  class BusinessEnv extends Boss with Employee with Customer {
    override def print: Unit = {
      println("business env")
      super.print
    }
  }

  (new BusinessEnv).print

}
