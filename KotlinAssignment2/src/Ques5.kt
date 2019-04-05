import java.util.*

fun main(){
    val reader=Scanner(System.`in`)
    println("Enter the marks")
    val b=reader.nextInt()
val a=A()
    a.marks(b)
}
class A{

    fun marks(i:Int){
        if(i in 50..60){
            println("good")
        }else if (i in 60..70){
            println("Very Good")
        }else if (i in 70..80){
            println("Excellent")
        }else if (i in 80..100){
            println("RockStar")
        }else{
            println("Work Hard")
        }
    }
}