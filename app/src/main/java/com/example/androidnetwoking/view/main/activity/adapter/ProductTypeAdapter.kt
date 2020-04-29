package com.example.androidnetwoking.view.main.activity.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetwoking.R
import com.example.androidnetwoking.data.model.ProductTypes


class ProductTypeAdapter : RecyclerView.Adapter<ProductTypeAdapter.ViewHolder>() {
    private var productTypes: MutableList<ProductTypes> = mutableListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.tv_name)
        private val description = itemView.findViewById<TextView>(R.id.tv_description)
        fun onBind(productTypes: ProductTypes) {
            name.text = productTypes._name
            description.text = productTypes._description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productTypes.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productTypes = productTypes[position]
        holder.onBind(productTypes)
    }

    fun swapItems(list: MutableList<ProductTypes>) {
        val typeDiff = ProductTypeDiff(this.productTypes, list)
        val diff: DiffUtil.DiffResult = DiffUtil.calculateDiff(typeDiff)
        calculate(list)
        diff.dispatchUpdatesTo(this)
    }

     fun calculate(list: MutableList<ProductTypes>) {
        productTypes.clear()
        productTypes.addAll(list)
    }

}


