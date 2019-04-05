import java.util.*

//Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String.
fun main() {
    var reader = Scanner(System.`in`)
    println("Enter the String")
    var mStr = reader.nextLine()
    var mLowercase: Int = 0
    var mUppercase: Int = 0
    var mDigits: Int = 0
    var mOthers = 0
    for (char in mStr) {
        when {
            char.isLowerCase() -> mLowercase += 1
            char.isUpperCase() -> mUppercase += 1
            char.isDigit() -> mDigits += 1
            else -> mOthers += 1

        }
    }
    val totalChar: Int = mDigits + mLowercase + mUppercase + mOthers
    println("No. of Lowercase letters: $mLowercase, Percentage of Lowercase letters: ${(mLowercase* 100 / totalChar).toFloat()}")
    println("No. of Uppercase letters: $mUppercase, Percentage of Uppercase letters: ${(mUppercase * 100 / totalChar).toFloat()}")
    println("No. of Digits: $mDigits, Percentage of Digits: ${(mDigits * 100 / totalChar).toFloat()}")
    println("No. of Special Characters $mOthers, Percentage of Special Characters: ${(mOthers * 100 / totalChar).toFloat()}")


}