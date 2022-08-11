package lectures.week5

object Greeting extends App {

  case class Greeting(text: String) {
    def name: String = "name"
    def occupation: String = "admin"
    def level: String = "middle"
  }

  implicit class ImplicitGreeting(text: String) extends Greeting(text) {
    implicit def isMiddle: Boolean = {
      if (text == "middle") true
      else false
    }

  }

  val greeting = "My name is [ X ] and I'm a [ Y ]. And I have [ Z ] years of experience."

  println(greeting.name)
  println(greeting.occupation)
  println(greeting.level)
  println(greeting.level.isMiddle)

}
