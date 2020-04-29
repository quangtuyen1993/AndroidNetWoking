package com.example.androidnetwoking.api

import com.example.androidnetwoking.data.model.ProductTypes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProductTypeApi {
    @GET("api/productType")
    suspend fun onFetchProviderType(): Response<MutableList<ProductTypes>>
}