package lectures.week3fp

object PartialFunc extends App {
  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }
//  println(aPartialFunction("sun")) // Relax a little
//  println(aPartialFunction("sat")) // MatchError

  // напишите ваш код здесь
  val chatbotNonLifted: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }

  val chatbot = chatbotNonLifted.lift

//  scala.io.Source.stdin.getLines().foreach(line => println(chatbot(line)))
  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
}
