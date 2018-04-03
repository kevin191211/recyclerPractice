package com.example.ystar.recyclerview.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/////////////////////////////////////////////////////////////////////////////////////////////

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

/////////////////////////////////////////////////////////////////////////////////////////////

fun Any.toast(context: Context) {
    Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).show()
}

/////////////////////////////////////////////////////////////////////////////////////////////

