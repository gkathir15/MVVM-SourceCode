package com.jetpack.mvvm.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jetpack.mvvm.R
import com.jetpack.mvvm.model.adapter.listener.BaseRecyclerAdapterListener
import com.jetpack.mvvm.model.adapter.viewholder.BottleShopViewHolder
import com.jetpack.mvvm.databinding.InflateShopsBinding
import com.jetpack.mvvm.model.BottleShopResponse

class BottleShopAdapter(data: List<BottleShopResponse>, private val listener: BaseRecyclerAdapterListener<BottleShopResponse>?)
    : BaseRecyclerAdapter<BottleShopResponse, InflateShopsBinding, BottleShopViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottleShopViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.inflate_shops, parent, false)
        return BottleShopViewHolder(binding, listener)
    }
}