package com.jetpack.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counterLiveData = MutableLiveData<Int>()
    var counterValue: Int = 0

    fun onIncrementCounter() {
        counterValue += 3

        // Modify counter liveData Object with updated counter value
        counterLiveData.value = counterValue
    }

    fun onDecrementCounter() {
        counterValue --

        // Modify counter liveData Object with updated counter value
        counterLiveData.value = counterValue
    }

    /**
     *  Clear Application Memory Allocated for ViewModel which is similar to onDestroy in Activity/Fragment
     *  Happens when finish() or onBackPressed() get invoked
     */
    override fun onCleared() {
        super.onCleared()
        Log.e("CounterViewModel", "onCleared")
    }

}