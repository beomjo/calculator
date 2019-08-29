package k.bs.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val keyInputLiveData = MutableLiveData<String>()
}