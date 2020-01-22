package com.jetpack.mvvm.model.adapter.viewholder

import com.jetpack.mvvm.model.adapter.listener.BaseRecyclerAdapterListener
import com.jetpack.mvvm.databinding.InflateShopsBinding
import com.jetpack.mvvm.model.BottleShopResponse

class BottleShopViewHolder(binding: InflateShopsBinding, private val listener: BaseRecyclerAdapterListener<BottleShopResponse>?)
    : BaseViewHolder<BottleShopResponse, InflateShopsBinding>(binding.root, binding) {

    internal override fun populateData() {
        binding.response = data
    }

}