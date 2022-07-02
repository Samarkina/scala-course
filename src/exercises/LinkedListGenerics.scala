package exercises

object LinkedListGenerics extends App {
  //  last - возвращает последнее поступившее сообщение (иначе говоря - head списка)
  //  previous - возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
  //  isEmpty - проверяет, если ли в нашем списке сообщения
  //  all - предоставляет нам содержимое нашего списка в виде строки
  //  add(msg) - добавляет сообщение в список
  abstract class LogList[+A] {
    def last(): A

    def previous(): LogList[A]

    def isEmpty(): Boolean

    def all(): String

    def add[B >: A](msg: B): LogList[B]
  }

  class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {
    def add[B >: A](msg: B): LogList[B] = new Log[B](msg, this)

    def isEmpty(): Boolean = {
      if (this.last == "") true
      else false
    }

    def last(): A = head

    def previous(): LogList[A] = tail

    def all(): String = {
      def rec(acc: String, head_rec: A, tail_rec: LogList[A]): String = {
        if (tail_rec == Empty) s"$acc ${head_rec}"
        else s"${rec(s"$acc ${head_rec}", tail_rec.last, tail_rec.previous)}"
      }

      rec(s"${head}", tail.last, tail.previous)
    }
  }

  object Empty extends LogList[Nothing] {
    def add[Nothing](msg: Nothing) = new Log[Nothing](msg, Empty)

    def isEmpty(): Boolean = true

    def previous() = throw new NoSuchElementException

    def last() = throw new NoSuchElementException

    def all(): String = ""
  }

  val b = new Log[String]("m1", new Log[String]("m2", new Log[String]("m3", Empty)))
  val a = new Log[String]("", Empty)
  println(b.all)
  println(b.isEmpty)

}
