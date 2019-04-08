fun main() {
    val myLambda:(Double)->Unit={s:Double-> println(s)}
    SimpleInterest(7.0,8.0,9.0,myLambda)
}

fun SimpleInterest(i: Double, i1: Double, i2: Double, myLambda: (Double) -> Unit) {
val simpleInterset=(i*i1*i2)/100
    myLambda(simpleInterset)
}
