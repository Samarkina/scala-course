package exercises.week1basics

object AbstractClass extends App {
  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) { event = evt }
    def sendNotification() { event.trigger(eventName) }
  }

  val notification: Listener = new Listener("mousedown", null)

  notification.register(
    new Event() {
      override def trigger(eventName: String): Unit = println(s"trigger ${eventName} event")
    }
  )


}
