package lectures.week5

object Implisits extends App {
  case class Course(id: Int, title: String)

  val courses = List(
    Course(0, "Scala"),
    Course(1, "Advanced Scala"),
    Course(4, "Spark"),
    Course(3, "Cats")
  )
//  implicit val titleOrdering: Ordering[Course] = Ordering.by(c => (c.title))

  implicit val courseOrdering: Ordering[Course] = Ordering.by(i => (i.id, i.title))

  println(courses.sorted)
}
