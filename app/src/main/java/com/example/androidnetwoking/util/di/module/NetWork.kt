package com.example.androidnetwoking.util.di.module

import android.app.Application
import com.example.androidnetwoking.api.CustomerApi
import com.example.androidnetwoking.api.ProductApi
import com.example.androidnetwoking.api.ProductTypeApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetWork {


//    @Provides
//    @Singleton
//    fun provideHttpCache(application: Application): Cache? {
//        val cacheSize = 10 * 1024 * 1024
//        return Cache(application.cacheDir, cacheSize.toLong())
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkhttpClient(cache: Cache?): OkHttpClient? {
//        val client = OkHttpClient.Builder()
//        client.cache(cache)
//        return client.build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideGson(): Gson? {
//        val gsonBuilder = GsonBuilder()
//        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//        return gsonBuilder.create()
//    }
//

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.135:3000/")
//            .client(httpClient)
            .build();

    }

    @Provides
    @Singleton
    fun providerProviderType(retrofit: Retrofit): ProductTypeApi {
        return retrofit.create(ProductTypeApi::class.java)
    }

    @Provides
    @Singleton
    fun providerProvider(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun providerCustomer(retrofit: Retrofit): CustomerApi {
        return retrofit.create(CustomerApi::class.java)
    }
}