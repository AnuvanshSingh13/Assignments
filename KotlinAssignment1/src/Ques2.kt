import java.util.*
import kotlin.collections.HashMap
//Write a program to find the number of occurrences of the duplicate words in a string and print them.

fun main() {
    val reader = Scanner(System.`in`)
    println("Enter the String with duplicate words")
    var enteredString = reader.nextLine()
    enteredString = enteredString.toLowerCase()
    val arrayOfString = enteredString.split(" ")
    val chars = HashMap<String, Int>()
    for (items in arrayOfString) {
        if (items !in chars) {
            chars[items] = 1
        } else
            chars[items] = chars[items]!! + 1

    }
    println("The duplicate words are:")
    for (items in chars.keys) {
        println("$items: ${chars[items]}")
    }

}