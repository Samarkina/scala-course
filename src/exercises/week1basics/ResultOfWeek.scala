package exercises.week1basics

object ResultOfWeek extends App {
  def reverse_trim_print(input: String): Unit = {
    /** Modifies the input string so that the words in it are placed in reverse order,
     * and remove extra spaces.
     * For example, the string "I like     Scala" should be transformed into "Scala like I"
     */
    val arr = input.split(' ')
    val res = arr.filter(_.nonEmpty)
    res.reverse.foreach(s => print(s + ' '))
  }

  reverse_trim_print("I like     Scala")
}
