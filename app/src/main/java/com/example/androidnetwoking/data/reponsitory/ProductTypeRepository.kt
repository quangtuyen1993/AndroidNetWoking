package com.example.androidnetwoking.data.reponsitory

import com.example.androidnetwoking.api.ProductTypeApi
import javax.inject.Inject

class ProductTypeRepository
   @Inject constructor (private val productTypeApi:ProductTypeApi): BaseRepository()
{
    suspend fun onFetchProductType()=
       handleResult { productTypeApi.onFetchProviderType() }
}