package playground

object Versions extends App {
  /*
  -1 (if v1 < v2)
  0 (if v1 = v2)
  1 (if v1> v2)
   */
  def compare(v1: String, v2: String): Int = {
    val v1List: Array[Int] = v1.split('.').map(_.toInt)
    val v2List: Array[Int] = v2.split('.').map(_.toInt)

    val result = v1List.zipAll(v2List, 0, 0).map {
      case (l1, l2) => if (l1 > l2) return 1
      else if (l1 < l2) return -1
      else 2
    }

    return 0

  }

  val compared = compare("2.1", "2.01")
  println(compared)

}
