package com.example.androidnetwoking.api

import com.example.androidnetwoking.data.model.Product
import retrofit2.Response
import retrofit2.http.*

interface ProductApi {
    @GET("api/product")
    suspend fun onFetchProduct(
        @Query("productTypeId")
        productId: String
    ): Response<MutableList<Product>>

    @POST("api/product")
    @FormUrlEncoded
    suspend fun onInsert(
        @Field("_idProductType") idType: String,
        @Field("nameProduct") name: String,
        @Field(value = "price") price: Int
    ): Response<Product>

    @PUT("api/product")
    @FormUrlEncoded
    suspend fun onUpdate(
        @Field("_id") id: String,
        @Field("_idProductType") idType: String,
        @Field("nameProduct") name: String,
        @Field(value = "price") price: Int
    ): Response<Product>

    @DELETE("api/product")
    suspend fun onDelete(
        @Query("_id") id: String
    )
}