package com.jetpack.mvvm;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jetpack.mvvm.model.BottleShopResponse;

import java.lang.reflect.Type;
import java.util.List;


public class BottleShopApplication extends Application {

    private static BottleShopApplication mAppController;

    public static synchronized BottleShopApplication getInstance() {
        return mAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppController = this;
    }

    public RequestQueue getRequestQueue() {
        return Volley.newRequestQueue(mAppController);
    }

    public void addToRequestQueue(Request request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }

    public List<BottleShopResponse> getObjectFromJsonString(String jsonString, Type responseType) {
        try {
            return new Gson().fromJson(jsonString, responseType);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
