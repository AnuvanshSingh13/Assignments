
fun main() {
    //input used
    var arr: Array<Int> = arrayOf(5, 6, 5, 6, 8, 9, 8)
    var res = 0
    for (ml in arr)
        res = res xor ml
    //using xor operator since z xor z returns 0 and z xor 0 returns z
    print("The element that occurs once is $res")
}