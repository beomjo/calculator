package k.bs.calculator.calculator

import android.os.Bundle
import k.bs.calculator.MainActivity
import k.bs.calculator.MainViewModel
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.CalculatorFragmentBinding
import k.bs.calculator.extension.observe
import k.bs.calculator.module.mainScope
import org.koin.androidx.viewmodel.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.koin.getViewModel

class CalculatorFragment : BindingFragment<CalculatorFragmentBinding>() {

    private lateinit var calculatorVm: CalculatorViewModel

    private lateinit var mainVm: MainViewModel

    override fun getLayoutResId(): Int = R.layout.calculator_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBinding()
        observing()
    }

    private fun setBinding() {
        calculatorVm = getKoin().getOrCreateScope(mainScope).getViewModel(activity as MainActivity)
        mainVm = getKoin().getOrCreateScope(mainScope).getViewModel(activity as MainActivity)
        binding.lifecycleOwner = activity
        binding.vm = calculatorVm
    }

    private fun observing() {
        observe(calculatorVm.numberInputLiveData, ::keyInputEvent)
    }

    private fun keyInputEvent(it: String?) {
        mainVm.keyInputLiveData.value = it
    }
}
