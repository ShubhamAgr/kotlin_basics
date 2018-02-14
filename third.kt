
fun main(args : Array<String>){
  println("hello")
  Button().click()
}

/*
Interface in kotlin
Kotlin interfaces is similar of Java
They  can contain definition of abstract methods as well as Implementation of non abstract method..
**/

interface Clickable {
  //Regular method declaration
  fun click()
  // Method with a default Implementation
  fun showOff)() = println("I'm Clickable")
}

class Button : Clickable {
  override fun click() = println("I was clicked")
}

//Open , final and abstract modifer

//Kotlin classes are final by default

open class RichButton : Clickable { // This class is open : others can inheric from it..
  fun disable() {}  //This function is final : you can't override it in a subclass
  open fun animate() {} //This function is open we may override it in a subclass
  /* override fun click () {} //Thus function is override an open function and is open as well */
  final override fun click() {} // final  isn't redundant here because "Override " without "final " implies being open
}


//This class is abstract : we can't create an instance of it
abstract class Animated {

  //This function is abstract : it doesn't have an Implementation and must be overridden in subclass
  abstract fun animate()


  //Non -abstract function in abstract classes aren't open by default but can be marked as open
  open fun stopAnimating() {

  }
  fun animateTwice(){}
}


/**
*final --- Can't be overridden -----Used by default for class member
*open --- Can be overriden  -- should be specified explicitly
*abstract --- Must be overriden --- Can be used only in abstract classes : abstract members can't have an Implementation
*override --- Overrides a member in a superclass or interface --- Overridden member is open by default , if not marked final
**/


class Outer {
  inner class Inner {
    fun getOuterReference() : Outer = this@Outer
  }
}

//Sealed class
/**
Kotlin provides a  sealed classes .. we mark the super class with the sealed modifier , and that restricts the possibility of creating subclass
all the directed subclass must be nested in the superclass
*/

sealed class Expr {
  class Num(val value : Int) : Expr()
  class Sum(val left:Expr, val right : Expr):Expr()
}

fun eval (e: Expr) : Int =
  when (e) {
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.right) +  eval(e.left)
  }

//Initializing the Primary constructor and initializer blocks
//Parantheses is called a primary constructor..

class User constructor(_nickname: String) { // primary constructor
  val nickname : String

  init { //Initializer block
    nickname = _nickname
  }
}

  /** OR ***/
class User2 (val nickname : String){ //val means the corresponding property is generated for the constructor parameter
  
}

//Secondary constructor
open class User3{
    constructor(name: String){

    }
    constructor(name:String,age:Int)
}

//Data Class  : auto generated implementation of universal methods
/**
If want call to be convenient holder for data, we need to override the methods toString equals and hashcode
If we add modifier data to class the necessary methods are automatically generated

**/
