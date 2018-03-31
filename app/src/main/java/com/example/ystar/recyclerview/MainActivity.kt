package com.example.ystar.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this, listOf("1","2","3","4","5","6","7","8","9","10"))
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}
