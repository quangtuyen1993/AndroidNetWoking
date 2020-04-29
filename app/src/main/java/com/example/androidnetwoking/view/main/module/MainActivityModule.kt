package com.example.androidnetwoking.view.main.module

import androidx.lifecycle.ViewModel
import com.example.androidnetwoking.util.di.scope.ViewModelKey
import com.example.androidnetwoking.view.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel
}