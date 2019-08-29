package k.bs.calculator.calculator

import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    val numberInput = MutableLiveData<String>()

    fun onClickNumber(view: View) {
        if (view !is TextView) return
        else onInput(view.text.toString())
    }

    private fun onInput(key: String) {
        val value = numberInput.value ?: ""
        when (key) {
            "C" -> numberInput.value = ""
            "+" -> numberInput.value = value + key
            "+" -> numberInput.value = value + key
            "-" -> numberInput.value = value + key
            "*" -> numberInput.value = value + key
            "/" -> numberInput.value = value + key
            "0" -> {
                if (value == "0") return
                else numberInput.value = value + key
            }
            else -> numberInput.value = value + key
        }
    }
}
