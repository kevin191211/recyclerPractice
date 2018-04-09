package com.example.ystar.recyclerview

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import com.example.ystar.recyclerview.data.MainViewModel


/**
 * Created by ystar_000 on 2018/4/9.
 */
object SwipeRefreshLayoutDataBinding {

    /**
     * Reloads the data when the pull-to-refresh is triggered.
     *
     *
     * Creates the `android:onRefresh` for a [SwipeRefreshLayout].
     */
    @BindingAdapter("android:onRefresh")
    fun setSwipeRefreshLayoutOnRefreshListener(view: SwipeRefreshLayout,
            viewModel: MainViewModel) {
        view.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { viewModel.onRefresh(view) })
    }

}