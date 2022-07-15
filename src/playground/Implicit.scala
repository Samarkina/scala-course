package playground

object Implicit extends App {
  // probably in a library
  class Prefixer(val prefix: String)
  def addPrefix(s: String)(implicit p: Prefixer) = p.prefix + s

  // then probably in your application
  implicit val myImplicitPrefixer = new Prefixer("***")
  val a = addPrefix("abc")  // returns "***abc"
  println(a)

  val value = 10
  implicit val multiplier = 3
  def multiply(implicit by: Int) = value * by

  // Implicit parameter will be passed here
  val result = multiply

  // It will print 30 as a result
  println(result)


}
