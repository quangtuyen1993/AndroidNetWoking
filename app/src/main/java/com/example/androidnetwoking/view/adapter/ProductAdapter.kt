package com.example.androidnetwoking.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetwoking.R
import com.example.androidnetwoking.data.model.Product
import com.example.androidnetwoking.databinding.ProductItemViewBinding

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.ViewHolder>(),
    BindAbleAdapter<MutableList<Product>> {
    private var products: MutableList<Product> = mutableListOf()

    private lateinit var itemClick: ItemClick
    fun setItemClick(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    inner class ViewHolder(var binding: ProductItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()

            binding.btDelete.setOnClickListener {
                itemClick.clickDelete(product)
            }
            binding.btUpdate.setOnClickListener {
                itemClick.clickUpdate(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);
        val viewBinding: ProductItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.product_item_view, parent, false)
        return ViewHolder(viewBinding);
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun setData(data: MutableList<Product>) {
        this.products = data
        notifyDataSetChanged()
    }

    interface ItemClick {
        fun clickUpdate(product: Product)
        fun clickDelete(product: Product);
    }
}