package com.example.androidnetwoking.util.di.module

import android.app.Application
import com.example.androidnetwoking.AndroidApplication
import com.example.androidnetwoking.util.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providerApplication(application: AndroidApplication): Application {
        return application
    }
}