package lectures.week1basics

object Recursion extends App {
  import scala.annotation.tailrec


  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n)
  }


  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }


  def powerOfTwo(power: Int): BigInt = {
    @tailrec
    def loop(i: Int, acc: BigInt = 2): BigInt = {
      if (i <= 1) acc
      else loop(i - 1, 2 * acc)
    }

    loop(power)
  }

  val res = powerOfTwo(32)
  println(res)

}
