package k.bs.calculator.calculator

import android.os.Bundle
import androidx.lifecycle.Observer
import k.bs.calculator.MainViewModel
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.CalculatorFragmentBinding
import org.koin.android.ext.android.inject

class CalculatorFragment : BindingFragment<CalculatorFragmentBinding>() {

    private val calculatorVm: CalculatorViewModel by inject()

    private val mainVm: MainViewModel by inject()

    override fun getLayoutResId(): Int = R.layout.calculator_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBinding()
        observing()
    }

    private fun setBinding() {
        binding.lifecycleOwner = activity
        binding.vm = calculatorVm
    }

    private fun observing() {
        calculatorVm.numberInput.observe(this, Observer {
            mainVm.keyInputLiveData.value = it
        })
    }

}
