package k.bs.calculator

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import k.bs.calculator.binding.BindingActivity
import k.bs.calculator.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    val mainVm: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        binding.lifecycleOwner = this
        binding.vm = mainVm
    }
}
