import java.util.*
import kotlin.collections.HashSet

fun main() {
    //Find common elements between two arrays.
    val reader = Scanner(System.`in`)
    println("Enter the Array 1")
    val mArray1 = reader.nextLine().split("")
    println("Enter the Array 2")
    val mArray2 = reader.nextLine().split("")
    val mArray3 = hashSetOf<String>()
    for (i in mArray1) {
        for (j in mArray2) {
            if (i == j) {
                mArray3.add(i)
            }
        }
    }
    println(mArray3)
}