import java.util.*
//Write a program to find the number of occurrences of a character in a string without using loop.
fun main(){
   val reader=Scanner(System.`in`)
    println("Enter the String")
    var mString=reader.nextLine()
    println("Enter the charecter")
    var mChar=reader.next()
    var totalLength=mString.length
    var replaceLength=mString.replace(mChar,"").length
    println("No of Occurance = ${totalLength-replaceLength}")


}