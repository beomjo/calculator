package k.bs.calculator.module

import k.bs.calculator.MainViewModel
import k.bs.calculator.calculator.CalculatorViewModel
import k.bs.calculator.display.DisplayViewModel
import org.koin.dsl.module

val calculatorModules = module {
    single { MainViewModel() }
    factory { CalculatorViewModel() }
    factory { DisplayViewModel(get()) }
}