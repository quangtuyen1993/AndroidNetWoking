package com.example.androidnetwoking.view.main.fragment.homefragment

import androidx.lifecycle.ViewModel
import com.example.androidnetwoking.util.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule{
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun binHomeViewModel(homeViewModel: HomeViewModel):ViewModel

}