open class Bank {
    //Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific details like rateofinterest etc,print details of every bank.
    var rateOfInterest: Double = 0.0

    open fun getDetails() {
        rateOfInterest = 5.0
        println("$rateOfInterest")
    }
}

class SBI : Bank() {
    override fun getDetails() {
        rateOfInterest = 6.0
        println("$rateOfInterest")
    }
}

class BOI : Bank() {
    override fun getDetails() {
        rateOfInterest = 7.0
        println("$rateOfInterest")
    }
}

class ICICI : Bank() {
    override fun getDetails() {
        rateOfInterest = 9.0
        println("$rateOfInterest")
    }
}

fun main() {
    val bank = Bank()
    val sbi = SBI()
    val boi = BOI()
    val icici = ICICI()
    bank.getDetails()
    sbi.getDetails()
    boi.getDetails()
    icici.getDetails()

}