package lectures.week4

object CountChars extends App {
  def countChars(someString: String): Map[Char, Int] = {
    def loop(string: String, dict: Map[Char, Int]): Map[Char, Int] = {
      if (string.length == 1) addElem(string.head, dict)
      else loop(string.tail, addElem(string.head, dict))
    }

    def addElem(elem: Char, dict: Map[Char, Int]): Map[Char, Int] = {
      val lowerCaseElem: Char = elem.toLower
      if (dict.contains(lowerCaseElem)) {
        val newValue: Int = dict(lowerCaseElem) + 1
        dict - lowerCaseElem + (lowerCaseElem -> newValue)
      }
      else dict + (lowerCaseElem -> 1)
    }

    loop(someString, Map[Char, Int]())
  }
  val inputString = "abcbbbc"
  val result = countChars(inputString).toList.sortBy(_._2)
  println(result)
}
