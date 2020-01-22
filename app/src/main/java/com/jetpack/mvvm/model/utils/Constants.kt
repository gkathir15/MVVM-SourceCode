package com.jetpack.mvvm.model.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

object Constants {
    const val SHOP_URL: String = "https://api.openbrewerydb.org/breweries"
}