package com.example.androidnetwoking.api

import com.example.androidnetwoking.data.model.Customer
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CustomerApi {
    @POST("customer/login")
    @FormUrlEncoded
    suspend fun onLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<Customer>


    @POST("customer/register")
    @FormUrlEncoded
    suspend fun onRegister(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<Customer>
}