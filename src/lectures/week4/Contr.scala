package lectures.week4

object Contr extends App {
  class Programmer(name: String)
  case class DataAnalyst(val name: String) extends Programmer(name)

  class Employee[+T](val employee: T) {
    def info() = println(employee)
  }
  val employee: Employee[DataAnalyst] = new Employee[DataAnalyst](DataAnalyst("Bob"))
  employee.info()

//  class Programmer
//  class DataAnalyst extends Programmer
//
//  class Employee[-T]
//  val employee: Employee[DataAnalyst] = new Employee[Programmer]


}
