package lectures.week4

object IsBalanced extends App {
  def isBalanced(aString: String): Boolean = {
    val open = aString.count(_ == '(')
    println(open)
    val close = aString.count(_ == ')')
    println(close)
    open == close
  }
  val string: String = "dsf(d)sf)"
  val result = isBalanced(string)
  println(result)

}
