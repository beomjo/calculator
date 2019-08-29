package k.bs.calculator.display

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import k.bs.calculator.R
import k.bs.calculator.binding.BindingFragment
import k.bs.calculator.databinding.DisplayFragmentBinding

class DisplayFragment : BindingFragment<DisplayFragmentBinding>() {

    companion object {
        fun newInstance() = DisplayFragment()
    }

    private lateinit var viewModel: DisplayViewModel

    override fun getLayoutResId(): Int = R.layout.display_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DisplayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
