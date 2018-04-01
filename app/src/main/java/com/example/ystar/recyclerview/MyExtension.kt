package com.example.ystar.recyclerview

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


interface RecyclerListener {
    fun loadMore()
    fun refresh()
}

fun RecyclerView.setListener(l: RecyclerListener) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        var mLastVisibleItem: Int = 0
        val mSwipeRefreshLayout = this@setListener.parent

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            mLastVisibleItem = (recyclerView?.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == RecyclerView.SCROLL_STATE_IDLE && mLastVisibleItem + 1 === recyclerView?.adapter?.itemCount) {
                if (mSwipeRefreshLayout is SwipeRefreshLayout) {
                    if (!mSwipeRefreshLayout.isRefreshing) {
                        l.loadMore()
                    }
                } else {
                    l.loadMore()
                }
            }
        }
    })

    val mSwipeRefreshLayout = this.parent
    if (mSwipeRefreshLayout is SwipeRefreshLayout) {
        mSwipeRefreshLayout.setOnRefreshListener {
            l.refresh()
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

/////////////////////////////////////////////////////////////////////////////////////////////