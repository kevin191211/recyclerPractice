package com.example.ystar.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BaseAdapter<T>(val layoutId: Int, val dataList: List<T>, val init: (View, T) -> Unit) : RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false), init)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bindView(dataList[position])
    }

    class ViewHolder<in T>(val view: View, val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindView(item: T) {
            init(itemView, item)
        }
    }
}