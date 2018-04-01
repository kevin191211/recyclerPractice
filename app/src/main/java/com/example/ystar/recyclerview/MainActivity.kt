package com.example.ystar.recyclerview

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_video.view.*

class MainActivity : AppCompatActivity() {

    private var dataList: MutableList<String> = arrayListOf()
    private lateinit var mAdapter: BaseAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataList.addAll(listOf("1", "2", "3", "4", "5", "6", "7"))
        mAdapter = BaseAdapter(R.layout.item_video, dataList) { view: View, item: String ->
            view.txv_title.text = item
            view.setOnClickListener { Toast.makeText(this, "click:$item", Toast.LENGTH_SHORT).show() }
        }
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        swipe_refresh_layout.setOnRefreshListener {
            Handler().postDelayed({
                swipe_refresh_layout.isRefreshing = false
                dataList.add(0, "add")
                mAdapter.refresh(dataList)
            },3000)
        }
    }
}
