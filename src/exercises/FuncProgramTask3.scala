package exercises

object FuncProgramTask3 extends App {
  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    network + (location -> Set())
  }

  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))

    val disconnected = loop(network(location), network)

    disconnected - location // remove a key
  }

  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA) - pointB
    val routesForB: Set[String] = network(pointB) - pointA
    val tempNetwork = network - pointA - pointB
    tempNetwork + (pointA -> routesForA) + (pointB -> routesForB)
  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  def nFlights(network: Map[String, Set[String]], location: String): Int = {
    /*
    returns the number of available direct flights from the given point
     */
    network(location).size
  }

  def mostFlights(network: Map[String, Set[String]]): String = {
    /*
    returns the point from which the most direct flights are available
     */
    network.maxBy(_._2.count(z=>true))._1
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
    /*
    checks if two points are connected
     */
    def traverse[A](graph : Map[A,Set[A]], toVisit : Seq[A], visited : Set[A]) : Seq[A] = {
      if(toVisit.isEmpty) {
        Seq.empty
      } else {
        val next = toVisit.head
        val succ = (graph(next) -- visited -- toVisit).toSeq
        // DFS :
        // next +: traverse(graph, succ ++ toVisit.tail, visited + next)
        // BFS :
        next +: traverse(graph, toVisit.tail ++ succ, visited + next)
      }
    }

    def traverseFrom[A](graph : Map[A,Set[A]], initial : A) =
      traverse(graph, Seq(initial), Set.empty)

    if (traverseFrom(network, pointA).contains(pointB)) true
    else false

  }

  val network: Map[String, Set[String]] = Map("A" -> Set("B"), "B" -> Set("A", "C"), "C" -> Set("B"), "D" -> Set("F"), "F" -> Set("D"))

  println(isConnected(network, "A", "D")) //false
  println(isConnected(network, "A", "C")) //true

}
