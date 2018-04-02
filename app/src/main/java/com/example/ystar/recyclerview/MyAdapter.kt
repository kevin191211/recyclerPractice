package com.example.ystar.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.ystar.recyclerview.MyAdapter.ViewHolder

/**
 * Created by ystar_000 on 2018/4/2.
 */

class MyAdapter<T>(private val layoutId: Int, private var items: List<T>,
        private val init: (View, T) -> Unit) : RecyclerView.Adapter<ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        return ViewHolder(parent.inflate(layoutId), init)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder<in T>(view: View, private val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(item: T) {
            init(itemView, item)
        }
    }
}
