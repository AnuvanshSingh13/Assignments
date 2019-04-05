class overLoading {
    //Write a single program for following operation using overloading
    //  A) Adding 2 integer number
    //  B) Adding 2 double
    //  D) multiplying 2 int
    //  E) concate 2 string
    //  F) Concate 3 String
    fun add(a: Int, b: Int): Int = a + b

    fun add(a: Double, b: Double): Double = a + b
    fun multiply(a: Int, b: Int): Int = a * b
    fun multiply(a: Double, b: Double): Double = a * b
    fun concat(a: String, b: String): String = a + b
    fun concat(a: String, b: String, c: String): String = a + b + c
}

fun main() {
    val overLoadings = overLoading()
    println(overLoadings.add(2, 3))
    println(overLoadings.add(3.5, 4.5))
    println(overLoadings.multiply(6, 7))
    println(overLoadings.multiply(3.5, 4.5))
    println(overLoadings.concat("hello", "google"))
    println(overLoadings.concat("how", "are", "you"))

}