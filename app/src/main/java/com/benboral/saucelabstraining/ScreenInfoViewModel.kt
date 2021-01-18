package com.benboral.saucelabstraining


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenInfoViewModel : ViewModel() {

    val clickCount = MutableLiveData<Int>()
    val buttonText = "Click Me!"

    init {
        clickCount.value = 0
    }

    fun incrementCount() {
        clickCount.value = clickCount.value?.plus(1)
    }

}