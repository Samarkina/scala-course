package exercises

object LogSystem extends App {
  class Logger(val msgNum: Int) {

    def this() = this(0)

    def info(): Logger = {
      println("INFO New Message")
      new Logger(msgNum + 1)
    }

    def info(n: Int): Logger = {
      if (n <= 0) this
      else info.info(n - 1)
    }

    def print = println(msgNum)

  }
}
