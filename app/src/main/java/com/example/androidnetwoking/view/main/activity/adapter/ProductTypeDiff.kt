package com.example.androidnetwoking.view.main.activity.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.androidnetwoking.data.model.ProductTypes

class ProductTypeDiff(
    var listOld:MutableList<ProductTypes>,
    var listNew:MutableList<ProductTypes>
) : DiffUtil.Callback(){


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return listNew[newItemPosition]._id==
        listOld[oldItemPosition]._id
    }

    override fun getOldListSize(): Int =listOld.size

    override fun getNewListSize(): Int = listNew.size


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return listNew[newItemPosition]._id==
                listOld[oldItemPosition]._id
    }

}