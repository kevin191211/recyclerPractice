package com.example.ystar.recyclerview.adapter

import android.content.Context
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ystar.recyclerview.viewholder.ViewHolder

class HeaderAndFooterWrapper<T>(private val mContext: Context, private val mParent: RecyclerView,
        private val mInnerAdapter: RecyclerView.Adapter<ViewHolder<T>>)
    : RecyclerView.Adapter<ViewHolder<T>>() {

    companion object {
        private const val BASE_ITEM_TYPE_HEADER = 100000
        private const val BASE_ITEM_TYPE_FOOTER = 200000
    }

    private var mHeaderViews: SparseArrayCompat<View> = SparseArrayCompat()
    private var mFooterViews: SparseArrayCompat<View> = SparseArrayCompat()

    override fun getItemViewType(position: Int): Int {
        return when {
            isHeaderViewPos(position) -> mHeaderViews.keyAt(position)
            isFooterViewPos(position) -> mFooterViews.keyAt(position - getHeaderCount() - getRealItemCount())
            else -> mInnerAdapter.getItemViewType(position - getHeaderCount())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        return when {
            mHeaderViews.get(viewType) != null -> ViewHolder(mHeaderViews[viewType])
            mFooterViews.get(viewType) != null -> ViewHolder(mFooterViews[viewType])
            else -> mInnerAdapter.onCreateViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        when {
            isHeaderViewPos(position) -> return
            isFooterViewPos(position) -> return
            else -> mInnerAdapter.onBindViewHolder(holder, position - getHeaderCount())
        }
    }

    fun <Model> addHeaderView(model: Model, layoutId: Int, init: (View, Model) -> View) {
        val view = LayoutInflater.from(mContext).inflate(layoutId, mParent, false)
        mHeaderViews.put(getHeaderCount() + BASE_ITEM_TYPE_HEADER, init(view, model))
    }

    fun <Model> addFooterView(model: Model, layoutId: Int, init: (View, Model) -> View) {
        val view = LayoutInflater.from(mContext).inflate(layoutId, mParent, false)
        mFooterViews.put(getFooterCount() + BASE_ITEM_TYPE_FOOTER, init(view, model))
    }

    override fun getItemCount(): Int = getFooterCount() + getHeaderCount() + getRealItemCount()

    private fun isHeaderViewPos(position: Int) = position < mHeaderViews.size()

    private fun isFooterViewPos(position: Int) = position >= getHeaderCount() + getRealItemCount()

    private fun getRealItemCount() = mInnerAdapter.itemCount

    private fun getHeaderCount() = mHeaderViews.size()

    private fun getFooterCount() = mFooterViews.size()
}