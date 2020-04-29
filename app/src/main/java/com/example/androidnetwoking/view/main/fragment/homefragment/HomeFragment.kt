package com.example.androidnetwoking.view.main.fragment.homefragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager

import com.example.androidnetwoking.R
import com.example.androidnetwoking.view.main.fragment.homefragment.viewpager.HomeViewPagerAdapter
import com.example.androidnetwoking.view.main.viewmodel.MainViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    @Inject
    lateinit var factory:ViewModelProvider.Factory

    lateinit var vm:MainViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewPagerAdapter= HomeViewPagerAdapter(childFragmentManager);
        viewPager=view.findViewById(R.id.home_viewpager)
        viewPager.adapter=homeViewPagerAdapter

        vm=ViewModelProvider(this,factory)[MainViewModel::class.java]
        vm.list.observe(viewLifecycleOwner, Observer {
            homeViewPagerAdapter.setProductType(it)
        })
        vm.fetchListProductType()
    }
}
