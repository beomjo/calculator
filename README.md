# Calculator  


## Image
<img src="https://user-images.githubusercontent.com/39984656/67265189-1a291200-f4e8-11e9-9d2c-8bed5673746f.png" width="300" height="500">


## 기능
- 0,1,2 와 사칙연산, Clear, =
- 화면회전하여도 데이터 유지
- 앱종료후 다시 실행하여도 마지막 값 유지


## Use  
**AAC(viewModel,LiveData), Koin(DI), MVVM(DataBinding), SharedPreference**

## Test  
```
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
```
