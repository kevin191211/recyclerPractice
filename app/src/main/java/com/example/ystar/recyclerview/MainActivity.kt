package com.example.ystar.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_video.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = BaseAdapter(R.layout.item_video, listOf("1", "2", "3", "4", "5", "6", "7")) { view: View, item: String ->
            view.txv_title.text = item
            view.setOnClickListener { Toast.makeText(this, "click:$item", Toast.LENGTH_SHORT).show() }
        }
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

}
