package com.example.ystar.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.ystar.recyclerview.extension.inflate
import com.example.ystar.recyclerview.viewholder.ViewHolder

/**
 * Created by ystar_000 on 2018/4/4.
 */
class LoadMoreAdapter<T>(private val mInnerAdapter: RecyclerView.Adapter<ViewHolder<T>>,
        private val mLayoutId: Int?, private val loadMore: () -> Unit)
    : RecyclerView.Adapter<ViewHolder<T>>() {

    companion object {
        private const val ITEM_TYPE_LOAD_MORE = 3000000
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> =
            when (viewType) {
                ITEM_TYPE_LOAD_MORE -> ViewHolder(parent.inflate(mLayoutId!!))
                else -> mInnerAdapter.onCreateViewHolder(parent, viewType)
            }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) =
            when {
                isShowLoadMoreView(position) -> loadMore()
                else -> mInnerAdapter.onBindViewHolder(holder, position)
            }

    override fun getItemViewType(position: Int): Int =
            when {
                isShowLoadMoreView(position) -> ITEM_TYPE_LOAD_MORE
                else -> mInnerAdapter.getItemViewType(position)
            }

    override fun getItemCount(): Int =
            when (hasLoadMoreView()) {
                true -> mInnerAdapter.itemCount + 1
                else -> mInnerAdapter.itemCount
            }

    private fun hasLoadMoreView(): Boolean = mLayoutId != null

    private fun isShowLoadMoreView(position: Int): Boolean = hasLoadMoreView() && (position >= mInnerAdapter.itemCount)

}