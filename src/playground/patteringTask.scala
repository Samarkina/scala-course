package playground

object patteringTask extends App {
  def guard(data: Any, maxLength: Int): String = {
    data match {
      case x: List[Any] if x.length <= maxLength => s"Задан список List допустимой длины"
      case _: List[Any] => s"Длина списка больше максимально допустимого значения"
      case x: String if x.length <= maxLength => s"Длина строки не превышает максимально допустимого значения"
      case _: String => s"Получена строка недопустимой длины"
      case _ => s"Что это? Это не строка и не список"
    }
  }

  val list: List[Int] = List(1, 2)
  println(guard("Hello", 5))
  println(guard(list, 5))


}
