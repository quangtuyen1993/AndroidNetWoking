package com.example.androidnetwoking.util.di.module

import com.example.androidnetwoking.util.di.scope.ActivityScope
import com.example.androidnetwoking.view.login.activity.LoginActivity
import com.example.androidnetwoking.view.login.module.LoginFragmentBuilder
import com.example.androidnetwoking.view.login.module.LoginModule
import com.example.androidnetwoking.view.main.activity.MainActivity
import com.example.androidnetwoking.view.main.module.MainActivityModule
import com.example.androidnetwoking.view.main.module.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            ViewModelFactoryModule::class,
            MainFragmentModule::class]
    )
    abstract fun bindActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class,LoginFragmentBuilder::class])
    abstract fun bindLoginActivity(): LoginActivity
}