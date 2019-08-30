package k.bs.calculator.module

import k.bs.calculator.MainViewModel
import k.bs.calculator.calculator.CalculatorViewModel
import k.bs.calculator.display.DisplayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val mainScope = "MainScope"

val calculatorModules = module {
    scope(named(mainScope)) {
        single { MainViewModel() }
        viewModel { CalculatorViewModel() }
        viewModel { DisplayViewModel(get()) }
    }
}