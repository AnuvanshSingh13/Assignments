import Info.Companion.age
import Info.Companion.firstName
import Info.Companion.lastName

class Info {
    //Write a program to print your Firstname,LastName & age using init block,companion object.
    companion object {
        val firstName: String = "Anuvansh"
        val lastName: String = "Singh"
        val age: Int = 20
    }

    var firstName: String = ""
    var lastName: String = ""
    var age: Int = 0

    init {
        firstName = "vansh"
        lastName = "Chingh"
        age = 30
    }


}

fun main() {
    println("Information From init block:")
    println("FirstName: $firstName, LastName: $lastName, Age: $age")
    val info = Info()
    println("Information From Init Block")
    println("FirstName: ${info.firstName}, LastName: ${info.lastName}, Age: ${info.age}")
}