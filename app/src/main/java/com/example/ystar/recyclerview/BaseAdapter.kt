package com.example.ystar.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class BaseAdapter<T>(private val mLayoutId: Int, private val mDataList: MutableList<T>, private val init: (View, T) -> Unit) :
        RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        return ViewHolder(parent.inflate(mLayoutId), init)
    }

    override fun getItemCount(): Int = mDataList.size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bindView(mDataList[position])
    }

    class ViewHolder<in T>(view: View,private val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindView(item: T) {
            init(itemView, item)
        }
    }

    fun refresh(dataList: MutableList<T>) {
        val datas = dataList.toMutableList()
        mDataList.clear()
        mDataList.addAll(datas)
        notifyDataSetChanged()
    }
}

