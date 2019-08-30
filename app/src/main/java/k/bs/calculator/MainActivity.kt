package k.bs.calculator

import android.os.Bundle
import k.bs.calculator.binding.BindingActivity
import k.bs.calculator.databinding.ActivityMainBinding
import k.bs.calculator.module.mainScope
import org.koin.androidx.viewmodel.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    private val mainVm: MainViewModel by getKoin().getOrCreateScope(mainScope).viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        binding.lifecycleOwner = this
        binding.vm = mainVm
    }
}
