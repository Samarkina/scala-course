package lectures.week4

object Formatter extends App {
  def formatter(form: String)(value: Double): String = form.format(value)

  val simpleFormat = formatter("%.2f") _

  val numbers = List(1.23323, 2.4242, 3.4343, 4.6565)
  val result = numbers.map(simpleFormat)
  println(result)
}
