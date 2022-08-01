package lectures.week4

object BF extends App {
  val nameToFind = "John"
  case class User(name: String, bf: User)

  val users = List(
    User("Mike", User("Sam", User("Bob", User("Alice", null)))),
    User("John", User("Joe", null)),
  )

  object Service {
    def findUser(users: List[User], name: String): Option[User] = users.find(_.name == name)
  }

  def getBf(user: User): Option[User] = Option(user.bf)

  val bf = Service.findUser(users, nameToFind) match {
    case None => "No user"
    case user@Some(value) => user.flatMap(getBf).flatMap(getBf).map(_.name).getOrElse("No bf")
  }

  println(bf)
}
