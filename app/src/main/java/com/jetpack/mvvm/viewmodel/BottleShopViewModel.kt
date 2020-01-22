package com.jetpack.mvvm.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.mvvm.model.BottleShopResponse
import com.jetpack.mvvm.model.repositery.BottleShopRepo

class BottleShopViewModel(bottleShopRepo: BottleShopRepo) : ViewModel() {

    // Fetch Network Response from the Repo Layer
    private val breweriesLiveData = bottleShopRepo.getBottleShopsFromNetwork()

    // Return updated response
    fun getBreweries(): LiveData<List<BottleShopResponse>> {
        return breweriesLiveData
    }


    /**
     *  Clear Application Memory Allocated for ViewModel which is similar to onDestroy in Activity/Fragment
     *  Happens when finish() or onBackPressed() get invoked
     */
    override fun onCleared() {
        super.onCleared()
        Log.e("BottleShopViewModel", "onCleared")
    }
}
