package lectures.week5

object Compare extends App {
  case class Customer(id: String, name: String)

  case class Order(orderId: String, customer: Customer, date: String)

  trait CompareProvider[T] {
    def compare(orderA: T, orderB: T): Boolean
  }

  object CustomerCheck extends CompareProvider[Order] {
    def compare(orderA: Order, orderB: Order): Boolean = {
      orderA.customer.id == orderB.customer.id
    }
  }

  object DateAndCustomerCheck extends CompareProvider[Order] {
    def compare(orderA: Order, orderB: Order): Boolean = {
      (orderA.customer.id == orderB.customer.id) && (orderA.date == orderB.date)
    }
  }

  val firstOrder: Order = Order("1", Customer("1", "Kate"), "08/01/2022")
  val secondOrder: Order = Order("2", Customer("1", "Kate"), "07/01/2022")

  val result = CustomerCheck.compare(firstOrder, secondOrder)
  println(result)

  val result2 = DateAndCustomerCheck.compare(firstOrder, secondOrder)
  println(result2)

}
