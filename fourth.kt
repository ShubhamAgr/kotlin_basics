fun main(args:Array<String>){
  println("Chapter 5")
  val people = listOf(Person("Alice",29), Person("Bob",31))
  println("${people.maxBy {it.age}}")
  val maxAge = people.maxBy({p:Person ->p.age })
  val sum = {x: Int , y : Int -> x + y}
  println(sum(1,2))
  println("${maxAge}")
  val errors = listOf("403 Forbidden", "404 Not Found")
  printMessageWithPrefix(errors, "Error:")
  println(strLenSafe("abc"))
  println(strLenSafe(null))
}

data class Person(val name : String, val age : Int)

//Using the function parameters in a lambda

fun printMessageWithPrefix(message:Collection<String>, prefix:String) {
  message.forEach{
    println("$prefix $it")  //Takes an argument a lambda specifies what to do with each element
  }
}


// String?  is for may be String or null
// foo ?: bar  is for may be foo or if null then return bar ///?:///llll

fun strLenSafe(s: String?) : Int = s?.length ?: 0
