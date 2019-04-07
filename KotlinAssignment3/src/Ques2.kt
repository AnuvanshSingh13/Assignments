
object Singleton
{

    init {
        println("Singleton class invoked.")
    }
    var name = "Kotlin Objects"
    fun printName()
    {
        println(name)
    }

}

fun main(args: Array<String>) {
    Singleton.printName()
    Singleton.name = "Singleton"
    Singleton.printName()


}


