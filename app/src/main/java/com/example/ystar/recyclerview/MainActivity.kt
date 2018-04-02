package com.example.ystar.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.item_video.view.txv_title

class MainActivity : AppCompatActivity() {

    private var mDataList: MutableList<String> = arrayListOf()
    private lateinit var mAdapter: BaseAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        mDataList.addAll(listOf("1", "2", "3", "4", "5", "6", "7"))
        mAdapter = BaseAdapter(R.layout.item_video, mDataList) { view: View, item: String ->
            view.txv_title.text = item
            view.setOnClickListener { "click:$item".toast(this) }
        }
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setOnRefreshListener {
            it.isRefreshing = false
        }
        recycler_view.setOnLoadMoreListener {
            Log.e("xxxxx", "loadmore")
        }
    }
}
