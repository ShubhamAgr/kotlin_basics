/* import java.util.* */

fun main(args:Array<String>){
  println("hello")
  val set = hashSetOf(1,7,53)
  println("$set")
  val list = arrayListOf(1,7,52)
  println("$list")
  val map = hashMapOf(1 to "one",7 to "seven", 53 to "fifty-three")
  println("$map")
  println("${"Kotlin".lastChar()}")
  println(list.joinToString(separator = ";",prefix = "(", postfix = ")"))

  val strings : List<String> = listOf("first","second","third")
  val numbers : Collection<Int> = setOf(1,14,2)


 //Destructuring declaration
  val (number , name) = 1 to "one"

}
//Extension Function ..
fun String.lastChar() : Char = this.get(this.length -1)

//Utility function as extensions
fun<T> Collection<T>.joinToString(seperator : String = ",",prefix : String = "", postfix:String = ""):String {
  val result = StringBuilder(prefix)
  for((index,element) in this.withIndex()){
    if(index > 0) result.append(seperator)
    result.append(element)
  }
  result.append(postfix)
  return result.toString()
}
