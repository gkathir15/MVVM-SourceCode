package com.jetpack.mvvm.model.repositery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.reflect.TypeToken
import com.jetpack.mvvm.BottleShopApplication
import com.jetpack.mvvm.model.BottleShopResponse
import com.jetpack.mvvm.model.utils.Constants.SHOP_URL

class BottleShopRepo {

    private val breweriesLiveData = MutableLiveData<List<BottleShopResponse>>()

    /**
     * @Repo Layer - Should only have Network/Database Calls
     * */

    fun getBottleShopsFromNetwork(): LiveData<List<BottleShopResponse>> {

        // Success Response Listener
        val breweriesResponseListener = Response.Listener<String> { response ->

            val responseType = object : TypeToken<List<BottleShopResponse>?>() {}.type
            val bottleShopResponse = BottleShopApplication.getInstance().getObjectFromJsonString(response, responseType)

            // Change Event Dispatched by modifying the liveData using setValue/postValue
            breweriesLiveData.value = bottleShopResponse

        }

        // Network Call
        val stringRequest = StringRequest(GET, SHOP_URL, breweriesResponseListener, null)
        BottleShopApplication.getInstance().addToRequestQueue(stringRequest, "BottleShopAPI")

        return breweriesLiveData
    }

}