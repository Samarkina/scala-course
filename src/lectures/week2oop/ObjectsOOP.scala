package lectures.week2oop

object ObjectsOOP extends App {
  class MyString(val str: String) {
    private var extra = "extraData"
    override def toString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString("hello", "world")) // helloworld
  println(MyString("welcome")) // welcomeextraData
}
