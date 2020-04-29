package com.example.androidnetwoking.util.di.component

import android.app.Application
import com.example.androidnetwoking.AndroidApplication
import com.example.androidnetwoking.util.di.module.ActivityBuilder
import com.example.androidnetwoking.util.di.module.AppModule
import com.example.androidnetwoking.util.di.module.NetWork
import com.example.androidnetwoking.util.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetWork::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<AndroidApplication> {

    @Component.Builder
    interface Builder {
    @BindsInstance
    fun buildApplication(androidApplication: AndroidApplication): Builder
    fun build(): AppComponent
}

    override fun inject(application: AndroidApplication)

}