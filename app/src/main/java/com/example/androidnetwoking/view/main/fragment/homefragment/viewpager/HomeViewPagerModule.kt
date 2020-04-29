package com.example.androidnetwoking.view.main.fragment.homefragment.viewpager

import androidx.lifecycle.ViewModel
import com.example.androidnetwoking.util.di.scope.ViewModelKey
import com.example.androidnetwoking.view.main.fragment.homefragment.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewPagerModule
{
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewPagerViewModel::class)
    abstract fun binHomeViewModel(homeViewPagerViewModel: HomeViewPagerViewModel): ViewModel
}