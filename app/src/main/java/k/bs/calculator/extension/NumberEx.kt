package k.bs.calculator.extension

fun String?.toSafeDouble(): Double = this?.toDoubleOrNull() ?: 0.0