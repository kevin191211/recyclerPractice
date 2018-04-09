package com.example.ystar.recyclerview.data

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import com.example.ystar.recyclerview.extension.toast

/**
 * Created by ystar_000 on 2018/4/4.
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {



    fun onRefresh(it: SwipeRefreshLayout) {
        "On Refresh".toast(getApplication())
        Handler().postDelayed({
            val list: MutableList<String> = arrayListOf()
            for (i in 1..10) {
                list.add(i.toString())
            }
//            mAdapter.refresh(list)
//            mLoadMoreAdapter.notifyDataSetChanged()
            it.isRefreshing = false
        }, 1000)
    }
}