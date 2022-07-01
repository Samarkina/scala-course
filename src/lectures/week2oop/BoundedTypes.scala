package lectures.week2oop

object BoundedTypes extends App {
  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit
  class Pizza

  class Food[T <: Fruit](fruit: T)
  val food = new Food(new Banana)
  // val foodPizza = new Food(new Pizza) // doesn't work
}
