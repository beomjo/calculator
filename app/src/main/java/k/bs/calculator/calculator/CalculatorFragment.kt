package k.bs.calculator.calculator

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.CalculatorFragmentBinding

class CalculatorFragment : BindingFragment<CalculatorFragmentBinding>() {

    companion object {
        fun newInstance() = CalculatorFragment()
    }

    private lateinit var viewModel: CalculatorViewModel

    override fun getLayoutResId(): Int=R.layout.calculator_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
