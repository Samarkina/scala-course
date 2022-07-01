package lectures.week2oop

object Covariance extends App {
  class CovariantList[+A] {
    def add[B >: A](element: B): CovariantList[B] = new CovariantList[B]
  }

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  val fruit: Fruit = new Apple

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]

  fruitList.add(new Banana)

}
