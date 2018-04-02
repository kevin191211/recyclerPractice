package com.example.ystar.recyclerview

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by ystar_000 on 2018/4/2.
 */

fun RecyclerView.setOnRefreshListener(throwSwipeRefreshLayout: (SwipeRefreshLayout) -> Unit) {
    val swipeRefreshLayout = this.parent
    if (swipeRefreshLayout is SwipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener {
            throwSwipeRefreshLayout(swipeRefreshLayout)
        }
    }
}

fun RecyclerView.setOnLoadMoreListener(performLoadMore: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        var mLastVisibleItem = 0
        val mSwipeRefreshLayout = this@setOnLoadMoreListener.parent

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            mLastVisibleItem = (recyclerView?.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            // 當靜止的時候,且畫面出現最後一項
            if (newState == RecyclerView.SCROLL_STATE_IDLE && mLastVisibleItem + 1 === recyclerView?.adapter?.itemCount) {
                if (mSwipeRefreshLayout is SwipeRefreshLayout) {
                    if (!mSwipeRefreshLayout.isRefreshing) {
                        performLoadMore()
                    }
                } else {
                    performLoadMore()
                }
            }
        }
    })
}