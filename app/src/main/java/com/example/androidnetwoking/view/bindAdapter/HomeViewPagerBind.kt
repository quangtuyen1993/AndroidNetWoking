package com.example.androidnetwoking.view.bindAdapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetwoking.data.model.Product
import com.example.androidnetwoking.view.adapter.BindAbleAdapter


@BindingAdapter("data")
fun <T> bindAdapter(view: RecyclerView, data: T) {
    Log.e("data", data.toString())
    view.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
    if (view.adapter is BindAbleAdapter<*>) {
        if (data != null)
            (view.adapter as BindAbleAdapter<T>).setData(data)
    }

}

class HomeViewPagerBind