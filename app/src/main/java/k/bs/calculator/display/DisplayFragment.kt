package k.bs.calculator.display

import android.os.Bundle
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.DisplayFragmentBinding
import org.koin.android.ext.android.inject

class DisplayFragment : BindingFragment<DisplayFragmentBinding>() {

    private val displayVm: DisplayViewModel by inject()

    override fun getLayoutResId(): Int = R.layout.display_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        binding.lifecycleOwner = activity
        binding.vm = displayVm
    }

}
