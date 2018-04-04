package com.example.ystar.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.ystar.recyclerview.R.layout
import com.example.ystar.recyclerview.adapter.BaseAdapter
import com.example.ystar.recyclerview.adapter.HeaderAndFooterAdapter
import com.example.ystar.recyclerview.extension.setOnLoadMoreListener
import com.example.ystar.recyclerview.extension.setOnRefreshListener
import com.example.ystar.recyclerview.extension.toast
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.item_footer.view.footer_txv
import kotlinx.android.synthetic.main.item_header.view.header_subtitle
import kotlinx.android.synthetic.main.item_header.view.header_txv
import kotlinx.android.synthetic.main.item_video.view.txv_title

class MainActivity : AppCompatActivity() {

    private var mDataList: MutableList<String> = arrayListOf()
    private lateinit var mAdapter: BaseAdapter<String>
    private lateinit var mHeaderAndFooterAdapter: HeaderAndFooterAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataList.addAll(listOf("1", "2", "3", "4", "5", "6", "7"))

        initView()
    }

    private fun initView() {
        val person = Person("Kevin", "28")

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setOnRefreshListener {
            it.isRefreshing = false
        }
        recycler_view.setOnLoadMoreListener {
            Log.e("xxxxx", "loadmore")
        }

        mAdapter = BaseAdapter(layout.item_video, mDataList) { view: View, item: String ->
            view.txv_title.text = item
            view.setOnClickListener { "click:$item".toast(this) }
        }

        mHeaderAndFooterAdapter = HeaderAndFooterAdapter(this, recycler_view, mAdapter)

        mHeaderAndFooterAdapter.addHeaderView(R.layout.item_header, person) { view: View, item: Person ->
            bindHeaderView(view, item)
            return@addHeaderView view
        }

        mHeaderAndFooterAdapter.addFooterView(R.layout.item_footer, "FooterView") { view: View, item: String ->
            bindFooterView(view, item)
            return@addFooterView view
        }

        recycler_view.adapter = mHeaderAndFooterAdapter
    }

    private fun bindFooterView(view: View, item: String) {
        view.footer_txv.text = item
        view.setOnClickListener { "click:$item".toast(this) }
    }

    private fun bindHeaderView(view: View, item: Person) {
        view.header_txv.text = item.name
        view.header_subtitle.text = item.age
        view.setOnClickListener { "click:$item.name".toast(this) }
    }
}

data class Person(val name: String, var age: String)