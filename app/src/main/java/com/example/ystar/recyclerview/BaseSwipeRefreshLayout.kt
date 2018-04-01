package com.example.ystar.recyclerview

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet

class BaseSwipeRefreshLayout(context: Context, attributeSet: AttributeSet) : SwipeRefreshLayout(context, attributeSet) {
    init {
        setColorSchemeResources(android.R.color.holo_red_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light)
    }
}