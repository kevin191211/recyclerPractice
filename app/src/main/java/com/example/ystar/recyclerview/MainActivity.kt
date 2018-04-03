package com.example.ystar.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.item_footer.view.footer_txv
import kotlinx.android.synthetic.main.item_header.view.header_txv
import kotlinx.android.synthetic.main.item_video.view.txv_title

class MainActivity : AppCompatActivity() {

    private var mDataList: MutableList<String> = arrayListOf()
    private lateinit var mAdapter: BaseAdapter<String>
    private lateinit var mHeaderAndFooterWrapper: HeaderAndFooterWrapper<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataList.addAll(listOf("1", "2", "3", "4", "5", "6", "7"))
        initView()
    }

    private fun initView() {

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setOnRefreshListener {
            it.isRefreshing = false
        }
        recycler_view.setOnLoadMoreListener {
            Log.e("xxxxx", "loadmore")
        }

        mAdapter = BaseAdapter(R.layout.item_video, mDataList) { view: View, item: String ->
            view.txv_title.text = item
            view.setOnClickListener { "click:$item".toast(this) }
        }

        mHeaderAndFooterWrapper = HeaderAndFooterWrapper(this, recycler_view, mAdapter)

        mHeaderAndFooterWrapper.addHeaderView("HeaderView", R.layout.item_header) { view: View, s: String ->
            view.header_txv.text = s
            view.setOnClickListener { "click:$s".toast(this) }
            return@addHeaderView view
        }

        mHeaderAndFooterWrapper.addFooterView("FooterView", R.layout.item_footer) { view: View, s: String ->
            view.footer_txv.text = s
            view.setOnClickListener { "click:$s".toast(this) }
            return@addFooterView view
        }

        recycler_view.adapter = mHeaderAndFooterWrapper


    }
}
