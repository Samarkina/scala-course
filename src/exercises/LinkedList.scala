package exercises

object LinkedList extends App {
  //  last - возвращает последнее поступившее сообщение (иначе говоря - head списка)
  //  previous - возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
  //  isEmpty - проверяет, если ли в нашем списке сообщения
  //  all - предоставляет нам содержимое нашего списка в виде строки
  //  add(msg) - добавляет сообщение в список
  abstract class LogList {
    def last(): String

    def previous(): LogList

    def isEmpty(): Boolean

    def all(): String

    def add(msg: String): LogList
  }

  class Log(head: String, tail: LogList) extends LogList {
    def add(msg: String): LogList = new Log(msg, this)

    def isEmpty(): Boolean = {
      if (this.last == "") true
      else false
    }

    def last(): String = head

    def previous(): LogList = tail

    def all(): String = {
      def rec(acc: String, head_rec: String, tail_rec: LogList): String = {
        if (tail_rec == Empty) s"$acc ${head_rec}"
        else s"${rec(s"$acc ${head_rec}", tail_rec.last, tail_rec.previous)}"
      }
      rec(s"${head}", tail.last, tail.previous)
    }
  }

  object Empty extends LogList {
    def add(msg: String): LogList = new Log(msg, Empty)

    def isEmpty(): Boolean = true

    def previous() = throw new NoSuchElementException

    def last() = throw new NoSuchElementException

    def all(): String = ""
  }

  val b = new Log("m1", new Log("m2", new Log("m3", Empty)))
  val a = new Log("", Empty)
  println(b.all)
  println(b.isEmpty)

}
