package k.bs.calculator.calculator

import k.bs.calculator.extension.toSafeDouble
import java.text.DecimalFormat

enum class OperatorType(val sign: String) {
    NONE(""),
    ADD("+"),
    SUB("-"),
    DIV("/"),
    MUL("*");
}

fun OperatorType.calculate(
    buf2: String?,
    buf1: String?
): String {
    val result = when (this) {
        OperatorType.ADD -> buf2.toSafeDouble() + buf1.toSafeDouble()
        OperatorType.SUB -> buf2.toSafeDouble() - buf1.toSafeDouble()
        OperatorType.DIV -> buf2.toSafeDouble() / buf1.toSafeDouble()
        OperatorType.MUL -> buf2.toSafeDouble() * buf1.toSafeDouble()
        else -> 0.0
    }

    return DecimalFormat("#.##").format(result)

}

