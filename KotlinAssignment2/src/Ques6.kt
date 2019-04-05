fun main(){
    val numbers:MutableList<Int> = mutableListOf(1,2,3,3,4,5)
    println("$numbers")
    numbers[2] = 4
    println(numbers)
}