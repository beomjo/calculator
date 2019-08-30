package k.bs.calculator.display

import android.os.Bundle
import k.bs.calculator.MainActivity
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.DisplayFragmentBinding
import k.bs.calculator.module.mainScope
import org.koin.androidx.viewmodel.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.koin.getViewModel

class DisplayFragment : BindingFragment<DisplayFragmentBinding>() {

    private lateinit var displayVm: DisplayViewModel

    override fun getLayoutResId(): Int = R.layout.display_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        displayVm = getKoin().getOrCreateScope(mainScope).getViewModel(activity as MainActivity)
        binding.lifecycleOwner = activity
        binding.vm = displayVm
    }
}
