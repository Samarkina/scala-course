package lectures.week2oop

object AbstractOOP extends App {
  abstract class BaseDataSource(dataSourceName: String) {
    def save: String = {
      s"Save method implemented"
    }

    def delete: String = {
      s"Delete method implemented"
    }

    val user: String
    def connect: String
  }

  val someSource = new BaseDataSource("someDS") {
    override val user: String = "someSourceUser"

    override def connect: String = "someSource connection"
  }

}
