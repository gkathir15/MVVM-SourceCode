package com.jetpack.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpack.mvvm.view.BottleShopActivity
import com.jetpack.mvvm.view.CounterActivity
import com.jetpack.mvvm.view.DataBindingDemoActivity

class MenuViewModel : ViewModel() {

    val dbText = "Two-Way DataBinding Demo"

    val vmText = "ViewModel"

    val liveText = "ViewModel + LiveData"

    val intentMutableLiveData = MutableLiveData<Class<*>>()


    fun onDataBindingClick() {
        intentMutableLiveData.postValue(DataBindingDemoActivity::class.java)
    }

    fun onViewModelClick() {
        intentMutableLiveData.postValue(CounterActivity::class.java)
    }

    fun onLiveDataViewModelClick() {
        intentMutableLiveData.postValue(BottleShopActivity::class.java)
    }

    /**
     *  Clear Application Memory Allocated for ViewModel which is similar to onDestroy in Activity/Fragment
     *  Happens when finish() or onBackPressed() get invoked
     */
    override fun onCleared() {
        super.onCleared()
        Log.e("MainViewModel", "onCleared")
    }

}