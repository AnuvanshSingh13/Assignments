import java.util.*
//Write a program to replace a substring inside a string with other string.

fun main(args:Array<String>){
    val reader=Scanner(System.`in`)
    println("Input your String")
    var enteredString= reader.nextLine()
    println("old value is : $enteredString")

    println("Input Substring to be replaced")
    var esubString= reader.nextLine()

    println("Enter Substring from which parent substring get replaced")
    var psubString=reader.nextLine()
    println("The replaced value is: ${enteredString.replace(esubString,psubString)}")
}

