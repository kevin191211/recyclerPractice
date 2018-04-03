package com.example.ystar.recyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by ystar_000 on 2018/4/3.
 */
class ViewHolder<in T>(view: View, private val init: ((View, T) -> Unit)? = null) : RecyclerView.ViewHolder(view) {
    fun bindView(item: T) {
        init?.invoke(itemView, item)
    }
}