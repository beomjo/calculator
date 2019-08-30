package k.bs.calculator.calculator

import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import k.bs.calculator.preference.PreferencesHelper

class CalculatorViewModel : ViewModel() {

    val numberInputLiveData = MutableLiveData<String>()

    var operatorType: OperatorType = OperatorType.NONE
    var buf1: String? = null
    var buf2: String? = null
    var resultBuf = ""
    var nexToTheSign = false

    init {
        restore()
    }

    private fun restore() {
        numberInputLiveData.value = PreferencesHelper[DISPLAY]
        buf1 = PreferencesHelper[BUF1].let { if (it.isNotEmpty()) it else null }
        resultBuf = PreferencesHelper[RESULT_BUF].let { if (it.isNotEmpty()) it else "" }
    }

    fun onClickNumber(view: View) {
        if (view !is TextView) return
        else onInput(view.text.toString())
    }

    private fun onInput(key: String) {
        val value = numberInputLiveData.value ?: ""
        when (key) {
            "+" -> storeBuf(OperatorType.ADD)
            "-" -> storeBuf(OperatorType.SUB)
            "/" -> storeBuf(OperatorType.DIV)
            "*" -> storeBuf(OperatorType.MUL)
            "C" -> clear()
            "=" -> calculateEnd()
            else -> append(key, value)
        }
    }

    private fun storeBuf(opType: OperatorType) {
        if (!buf1.isNullOrEmpty() && !buf2.isNullOrEmpty()) calculateEnd()
        else {
            operatorType = opType
            buf2 = buf1 ?: buf2 ?: resultBuf
            buf1 = null
            resultBuf = ""
            nexToTheSign = true
        }
    }

    private fun clear() {
        numberInputLiveData.value = ""
        clearBuf()
    }

    private fun calculateEnd() {
        if (remainedResultCheck()) numberInputLiveData.value = resultBuf
        else {
            displayResult()
            clearBuf()
        }
    }

    private fun remainedResultCheck() = resultBuf.isNotEmpty() && buf2.isNullOrEmpty()

    private fun displayResult() {
        val result = operatorType.calculate(buf2, buf1)
        resultBuf = result
        numberInputLiveData.value = result
    }

    private fun clearBuf() {
        operatorType = OperatorType.NONE
        buf1 = null
        buf2 = null
    }

    private fun append(key: String, value: String) {
        if (operatorType != OperatorType.NONE && nexToTheSign) nextToSignEvent(key)
        else displayAppend(value, key)
    }

    private fun nextToSignEvent(key: String) {
        numberInputLiveData.value = key
        buf1 = key
        nexToTheSign = false
    }

    private fun displayAppend(value: String, key: String) {
        val input = value + key
        buf1 = input
        numberInputLiveData.value = input
    }

    override fun onCleared() {
        super.onCleared()
        save()
    }

    private fun save() {
        PreferencesHelper[DISPLAY] = numberInputLiveData.value ?: ""
        PreferencesHelper[BUF1] = buf1 ?: ""
        PreferencesHelper[RESULT_BUF] = resultBuf
    }

    companion object {
        const val DISPLAY = "calculatorDisplay"
        const val BUF1 = "buf1"
        const val RESULT_BUF = "resultBuf"
    }
}
