package com.benboral.saucelabstraining


import androidx.lifecycle.*

class ScreenInfoViewModel : ViewModel(), LifecycleObserver {

    val clickCount = MutableLiveData<Int>()
    val buttonText = "Click Me!"

    init {
        clickCount.value = 0
    }

    fun incrementCount() {
        clickCount.value = clickCount.value?.plus(1)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun resetCounter() {
        clickCount.value = 0
    }

}