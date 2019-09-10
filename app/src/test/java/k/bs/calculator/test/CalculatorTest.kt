package k.bs.calculator.test

import k.bs.calculator.calculator.CalculatorViewModel
import k.bs.calculator.calculator.OperatorType
import k.bs.calculator.module.calculatorModules
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject

class CalculatorTest : TestBase(calculatorModules) {

    private val calculator by inject<CalculatorViewModel>()

    @Test
    fun numberInputTest() {
        enter("2")
        test("2")
    }

    @Test
    fun calculateAddExecuteTest() {
        calculate("2", "1", OperatorType.ADD)
        test("3")
    }

    @Test
    fun calculateSubExecuteTest() {
        calculate("2", "1", OperatorType.SUB)
        test("1")
    }

    @Test
    fun calculateSubNegativeNumberTest() {
        calculate("1", "3", OperatorType.SUB)
        test("-2")
    }

    @Test
    fun calculateMulExecuteTest() {
        calculate("2", "1", OperatorType.MUL)
        test("2")
    }

    @Test
    fun calculateDivExecuteTest() {
        calculate("4", "2", OperatorType.DIV)
        test("2")
    }

    @Test
    fun calculateDivDecimalPointTest() {
        calculate("5", "2", OperatorType.DIV)
        test("2.5")
    }

    @Test
    fun calculates() {
        calculate("2", "5", OperatorType.DIV)
        test("0.4")
    }

    @Test
    fun divideByZero() {
        calculate("4", "0", OperatorType.DIV)
        test("∞")
    }

    @Test
    fun calculateContinueTest() {
        calculate("2", "1", OperatorType.ADD)
        test("3")

        enter("+")
        enter("1")
        enter("=")

        test("4")
    }

    @Test
    fun twoSignInputTest() {
        enter("2")
        enter("+")
        enter("1")
        enter("+")
        test("3")

    }

    @Test
    fun multipleSignInputTest() {
        enter("100")
        enter("+")
        enter("-")
        enter("-")
        enter("*")
        enter("100")
        enter("=")
        test("10000")
    }

    @Test
    fun clearTest() {
        enter("2")
        test("2")
        enter("C")
        test("")
    }

    @Test
    fun pushEqualCheckRemainResultTest() {
        enter("100")
        enter("+")
        enter("100")
        enter("=")
        test("200")
        enter("=")
        test("300")
    }

    private fun enter(key: String) {
        calculator.onInput(key)
    }

    private fun test(expect: String) {
        Assert.assertEquals(expect, calculator.numberInputLiveData.value)
    }

    private fun calculate(a: String, b: String, opType: OperatorType) {
        enter(a)
        enter(opType.sign)
        enter(b)
        enter("=")
    }
}