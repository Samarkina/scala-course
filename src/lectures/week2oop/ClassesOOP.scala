package lectures.week2oop

object ClassesOOP extends App {
  //Instructor: id, name, surname
  //Methods:
  //- fullName: returns name and surname with capitalize first letter
  //
  //Course: courseID, title, releaseYear, instructor
  //Methods:
  //- getID: return id, format: courseID + instructor.id (ex. if courseId = 1, instructor.id = 2, then: 12)
  //- isTaughtBy(instructor): check if this instructor is a course instructor
  //- copyCourse(newReleaseYear): returns a new instance of the Course class
  // with the updated value of the releaseYear field

  class Instructor(val id: Int, val name: String, val surname: String) {
    def fullName(): String = {
      s"${name.capitalize} ${surname.capitalize}"
    }
  }

  class Course(val courseID: Int, val title: String, var releaseYear: String, var instructor: Instructor) {
    def getID(): String = {
      s"${courseID}${instructor.id}"
    }

    def isTaughtBy(instructor: Instructor): Boolean = {
      instructor.id == this.instructor.id
    }

    def copyCourse(newReleaseYear: String): Course = {
      new Course(courseID, title, newReleaseYear, instructor)
    }
  }



  def example() = {
    val instructor: Instructor = new Instructor(1, "Masha", "Smith")
    println(instructor.fullName())    // Masha Smith

    val course: Course = new Course(2, "Course Name", "1234", instructor)
    println(course.instructor.fullName())    // Masha Smith
    println(course.getID)    // 21
    println(course.isTaughtBy(instructor))    // true
    println(course.isTaughtBy(new Instructor(4, "Masha", "Smith")))    // false

    println(course.copyCourse("4321").releaseYear)    // 4321
  }


  example()





}
