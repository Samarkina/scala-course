package playground

object Recursion extends App {
  def task1(): Unit = {
    /** 1. increases the given number x by the number y n times
     * 2. displays the number obtained in step 1 as many times as there are digits in it,
     * and the phrase is the result
     */
    val fArgs = Array(10, 1, 5)

    def sum(res: Int, y: Int, n: Int): Int = {
      if (n <= 0) return res
      else return sum(res + y, y, n - 1)
    }

    val result = sum(fArgs(0), fArgs(1), fArgs(2))

    print_func(result, result)

    def print_func(res: Int, mod_res: Int): Unit = {
      if (mod_res <= 0) return None
      else {
        print(s"$res ")
        print_func(res, mod_res / 10)
      }

    }

    print("is the result")
  }

  task1()
}
