package com.example.androidnetwoking

import android.app.Application
import com.example.androidnetwoking.util.di.component.AppComponent
import com.example.androidnetwoking.util.di.component.DaggerAppComponent
import com.example.androidnetwoking.util.di.module.AppModule
import com.example.androidnetwoking.util.di.module.NetWork
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatcherActivity: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().buildApplication(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatcherActivity
    }


}