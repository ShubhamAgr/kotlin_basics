/** Kotlin Notes **/
//package geometry.shapes .. defining package name
import java.util.Random
import java.util.*
import java.io.*

fun main(args:Array<String>) {
  println(max(1,2))
  //Variables in Kotlin
  /*If we dont specify the type , the compiler analyzes the initlizer expression and uses its type as the variable type*/
  val question =  "The Ultimate Quesion of Life , the Universe, and Everything"
  val answer = 42
   // If explicitly wants to  specify the type...
  val answer2 : Int = 42
   // If a variable doesn't  have initilizer , we need to specify its type explicitly:
  val ans : Int
  ans = 43
  /*
  There are two keywords to declare variable :
   val (from value) -> Immutable refrence
   var (from variable) -> mutable refrence

   change it to var   change it to var if necesaary
  */
  println("question is : $question,answer is : $answer,new answer is :$answer2, new new answer is :$ans")
  val person = Person("Bob")
  val person2 = Person2("Bob",true) //call the constructor without the new keyword
  println(person.name) //accessing the property directly but the getter is invoked
  println(person2.isMarried)
  person2.isMarried = false
  println(person2.isMarried)

  val rectangle = Rectangle(41,43)
  println(rectangle.isSquare)
  println("rgb of blue ${Color2.BLUE.rgb()}")
  println("mnemonic of Blue ${getMnemonic(Color.BLUE)}")
  println("Mix Blue and yellow ${mix(Color.BLUE,Color.YELLOW)}")

  //Iterating in kotlin

  for(i in 1..100) {
    println("shubham:: $i")
  }
  println("Iterating over a range with a step")
  for(i in 100 downTo 1 step 2) {
    println("agrawal $i")
  }
 // c in 'a' .. 'z'  Transforms to a <= c && c <= z
  val binaryReps = TreeMap<Char,String>()
  for(c in 'A'..'F') {
    val binary = Integer.toBinaryString(c.toInt())
    binaryReps[c] = binary
  }

  for((letter, binary) in binaryReps) {  //Iterates over a map assigning the map key and value to two variables...
    println("$letter = $binary")
  }

  println(recognize('8'))

  val reader = BufferedReader(StringReader("239"))
  println(readNumber(reader))

  val reader2 = BufferedReader(StringReader("not a number"))
  readNum(reader2)
}

// The function declaration starts with the fun keyword , followed by the function name
// It is followed by the parameter list in parentheses . The return type comes after the parameter list, separated by a colon

fun max(a: Int, b : Int) : Int {   // block body
  return if (a > b) a else b
}

/**
The difference between a statement and an expression is that an expression has a value
which can be used as part of another expression, whereas  a statement is always a top level element in the enclosing bloc and
does not have its own value
In
*/

// we can simplify the previous function even further because body consist of a single expression
fun max2(a: Int, b:Int) : Int = if( a  > b ) a else b //expression body

fun recognize(c : Char) = when (c) {
  in '0' .. '9' -> "It's a digit"
  in 'a' .. 'z' -> "It's a letter"
  else -> "I don't know..."
}

//class in kotlin
//modifier public is default in kotlin

class Person(val name: String)

//declaring  mutable property in a class

class Person2(val name : String , var isMarried : Boolean)

//custom accessor

class Rectangle(val height : Int, val width: Int) {
  val isSquare : Boolean
    get() { // property getter declaration....
      return height == width
    }
}

fun createRandomRectangle() : Rectangle {
  val random = Random()
  return Rectangle(random.nextInt(), random.nextInt())
}

//enumurations

//Declaring simple enum class
enum class Color {
  RED,ORANGE,YELLOW,GREEN,BLUE,INDIGO,VIOLET;
}

//Declaring enum with properties

enum class Color2(val r: Int, val g: Int, val b: Int) {
  RED(255,0,0),ORANGE(255,165,0),YELLOW(255,255,0),
  GREEN(0,255,0),BLUE(0,0,255); // The semicolon here is required

  fun rgb() = (r * 256 + g) * 256 + b // Defines a method on the enum class
}

// when   ->  when is like switch .. case action of

fun getMnemonic(color: Color) =
  when(color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "york"
    Color.GREEN -> "gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "vain"
  }

  //combining option in one when branch
  fun getWarmth(color : Color) = when (color) {
    Color.RED, Color.ORANGE , Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO,Color.VIOLET -> "cold"
  }

  fun mix(c1:Color, c2: Color) =
    when (setOf(c1,c2)) {
      setOf(Color.RED,Color.YELLOW) -> Color.ORANGE
      setOf(Color.YELLOW,Color.BLUE) -> Color.GREEN
      setOf(Color.BLUE,Color.VIOLET) -> Color.INDIGO
      else -> throw Exception("Dirty color")
    }

//Exception handelling in Kotlin....  It is similar to the way it's done in java and many other languages

//throw IllegalArgumentException


//Using try as used in java
fun readNumber(reader: BufferedReader): Int? {
  try{
    val line = reader.readLine()
    return Integer.parseInt(line)
  }
  catch(e:NumberFormatException) {
    return null
  }
  finally{
    reader.close()
  }
}

//Using try as an expression
fun readNum(reader: BufferedReader) {
  val number = try {
    Integer.parseInt(reader.readLine())
  }catch(e: NumberFormatException) {
    return
  }

  println(number)
}

//Simple value object class with one property , value implementing the Expr interface
//The argument of a Sum Operation can be any Expr: either Num or another Sum
interface Expr
class Num(val value: Int) : Expr
class Sum(val left:Expr,val right:Expr) : Expr
