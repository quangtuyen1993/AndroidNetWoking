package com.example.androidnetwoking.util.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.androidnetwoking.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactoryModule: ViewModelFactory):ViewModelProvider.Factory
}