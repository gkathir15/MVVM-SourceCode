package com.jetpack.mvvm.model.adapter.listener

/**
 * Author: Douglas BR
 * Common method used for all RecyclerView who extends this interface.
 */

interface BaseRecyclerAdapterListener<T> {
    fun onClickItem(data: T, pos: Int)
}
