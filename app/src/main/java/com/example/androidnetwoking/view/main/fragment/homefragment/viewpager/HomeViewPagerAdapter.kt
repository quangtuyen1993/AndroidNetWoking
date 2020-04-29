package com.example.androidnetwoking.view.main.fragment.homefragment.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidnetwoking.data.model.ProductTypes

class HomeViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    private var productTypes: MutableList<ProductTypes> = mutableListOf()
    fun setProductType(data: MutableList<ProductTypes>) {
        productTypes=data
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        val productTypes = productTypes[position]
        return HomeViewPager.newInstance(productTypes)
    }

    override fun getCount(): Int = productTypes.size
}