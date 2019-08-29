package k.bs.calculator.calculator

import k.bs.calculator.extension.toSafeDouble

enum class OperatorType {
    NONE,
    ADD,
    SUB,
    DIV,
    MUL;
}

fun OperatorType.calculate(
    buf2: String?,
    buf1: String?
): String = when (this) {
    OperatorType.ADD -> buf2.toSafeDouble() + buf1.toSafeDouble()
    OperatorType.SUB -> buf2.toSafeDouble() - buf1.toSafeDouble()
    OperatorType.DIV -> buf2.toSafeDouble() / buf1.toSafeDouble()
    OperatorType.MUL -> buf2.toSafeDouble() * buf1.toSafeDouble()
    else -> 0.0
}.toString()