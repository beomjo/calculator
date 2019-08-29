package k.bs.calculator

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import k.bs.calculator.binding.BindingActivity
import k.bs.calculator.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}
