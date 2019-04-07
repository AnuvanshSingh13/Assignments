fun main() {
    var operation = SubClass1("Subclass1")
    //var operation=SubClass2("Subclass2")
    //var operation=SubClass3("Subclass3")

    var result = execute(operation)
    print("Result :$result")

}

sealed class ArithematicOperation
class SubClass1(var a: String) : ArithematicOperation()
class SubClass2(var a: String) : ArithematicOperation()
class SubClass3(var a: String) : ArithematicOperation()


fun execute(op: ArithematicOperation) = when (op) {
    is SubClass1 -> op.a
    is SubClass2 -> op.a
    is SubClass3 -> op.a

}