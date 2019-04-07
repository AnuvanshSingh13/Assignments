fun main(args: Array<String>) {
    try {
        Class.forName("NoClassDefFoundError")
    } catch (e: ClassNotFoundException) {
        e.printStackTrace()
    }}