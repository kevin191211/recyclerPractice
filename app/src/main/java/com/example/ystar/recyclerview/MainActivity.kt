package com.example.ystar.recyclerview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.ystar.recyclerview.R.layout
import com.example.ystar.recyclerview.adapter.BaseAdapter
import com.example.ystar.recyclerview.adapter.HeaderAndFooterAdapter
import com.example.ystar.recyclerview.adapter.LoadMoreAdapter
import com.example.ystar.recyclerview.data.Animal
import com.example.ystar.recyclerview.databinding.ActivityMainBinding
import com.example.ystar.recyclerview.extension.setOnRefreshListener
import com.example.ystar.recyclerview.extension.toast
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.item_footer.view.footer_txv
import kotlinx.android.synthetic.main.item_header.view.header_subtitle
import kotlinx.android.synthetic.main.item_header.view.header_txv
import kotlinx.android.synthetic.main.item_video.view.txv_title

class MainActivity : AppCompatActivity() {

    private val mDataList: MutableList<String> = arrayListOf()
    private val mPerson by lazy { Person("Kevin", "28") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
        initView()
    }

    private fun getData() {
        for (i in 1..10) {
            mDataList.add(i.toString())
        }
    }

    private fun initView() {

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setOnRefreshListener {
            "On Refresh".toast(this)
            Handler().postDelayed({
                val list: MutableList<String> = arrayListOf()
                for (i in 1..10) {
                    list.add(i.toString())
                }
                mAdapter.refresh(list)
                mLoadMoreAdapter.notifyDataSetChanged()
                it.isRefreshing = false
            }, 1000)
        }

        mHeaderAndFooterAdapter.addHeaderView(R.layout.item_header, mPerson) { view: View, item: Person ->
            bindHeaderView(view, item)
            return@addHeaderView view
        }

        mHeaderAndFooterAdapter.addFooterView(R.layout.item_footer, "FooterView") { view: View, item: String ->
            bindFooterView(view, item)
            return@addFooterView view
        }

        recycler_view.adapter = mLoadMoreAdapter

    }

    private val mLoadMoreAdapter: LoadMoreAdapter<String> by lazy {
        LoadMoreAdapter(mHeaderAndFooterAdapter, R.layout.item_load_more) {
            "On LoadMore".toast(this)
            Handler().postDelayed({
                val list: MutableList<String> = arrayListOf()
                for (i in 1..5) {
                    list.add(i.toString())
                }
                mAdapter.addAll(list)
                mLoadMoreAdapter.notifyDataSetChanged()
            }, 1000)
        }
    }

    private val mAdapter: BaseAdapter<String> by lazy {
        BaseAdapter(layout.item_video, mDataList) { view: View, s: String ->
            view.txv_title.text = s
            view.setOnClickListener { "Click $s!".toast(this) }
        }
    }

    private val mHeaderAndFooterAdapter: HeaderAndFooterAdapter<String> by lazy {
        HeaderAndFooterAdapter(this, recycler_view, mAdapter)
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