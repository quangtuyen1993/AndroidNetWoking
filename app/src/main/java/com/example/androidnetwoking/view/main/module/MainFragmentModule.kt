package com.example.androidnetwoking.view.main.module

import com.example.androidnetwoking.util.di.scope.FragmentScope
import com.example.androidnetwoking.view.main.fragment.homefragment.HomeFragment
import com.example.androidnetwoking.view.main.fragment.homefragment.HomeFragmentModule
import com.example.androidnetwoking.view.main.fragment.homefragment.viewpager.HomeViewPager
import com.example.androidnetwoking.view.main.fragment.homefragment.viewpager.HomeViewPagerModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule (){
    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun binFragmentHome():HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeViewPagerModule::class])
    abstract fun binViewPager():HomeViewPager
}