import java.util.ArrayList

fun main(args: Array<String>) {
    val employee = ArrayList<Employee>()
    employee.add(Employee("Anuvansh",  38))
    employee.add(Employee("Aditya",  32))
    employee.add(Employee("Aman",  20))
    employee.add(Employee("Ashu",  22))
    employee.add(Employee("Aparna",  20))

    val phase=employee.filter { it.age!! >=30 }.map { it.name }.joinToString { "$it have age more than 30" }
    println(phase)


}

class Employee(var name: String?, var age: Int?)