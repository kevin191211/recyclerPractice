package com.example.ystar.recyclerview

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class HeaderAndFooterWrapper<T>(private val mInnerAdapter: RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>, private val layoutId: Int, private val init: (View, T) -> Unit)
    : RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {

    companion object {
        private const val BASE_ITEM_TYPE_HEADER = 100000
        private const val BASE_ITEM_TYPE_FOOTER = 200000
    }

    private var mHeaderViews: SparseArrayCompat<View> = SparseArrayCompat()
    private var mFooterViews: SparseArrayCompat<View> = SparseArrayCompat()

    override fun getItemViewType(position: Int): Int {
        if (isHeaderViewPos(position)){
            return mHeaderViews.keyAt(position) + BASE_ITEM_TYPE_HEADER
        } else if (isFooterViewPos(position)){
            return mFooterViews.keyAt(position) + BASE_ITEM_TYPE_FOOTER
        }
        return mInnerAdapter.getItemViewType(position - getHeaderCount())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.ViewHolder<T> {
        if (mHeaderViews.get(viewType) != null) {
            return BaseAdapter.ViewHolder(parent.inflate(layoutId), init)
        }
    }

    override fun getItemCount(): Int = getFooterCount() + getHeaderCount() + getRealItemCount()

    override fun onBindViewHolder(holder: BaseAdapter.ViewHolder<T>, position: Int) {
    }

    private fun isHeaderViewPos(position: Int) = position < mHeaderViews.size()

    private fun isFooterViewPos(position: Int) = position >= getHeaderCount() + getRealItemCount()

    private fun getRealItemCount() = mInnerAdapter.itemCount

    private fun getHeaderCount() = mHeaderViews.size()

    private fun getFooterCount() = mFooterViews.size()
}