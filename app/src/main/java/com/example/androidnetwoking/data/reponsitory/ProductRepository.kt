package com.example.androidnetwoking.data.reponsitory

import com.example.androidnetwoking.api.ProductApi
import com.example.androidnetwoking.data.model.Product
import javax.inject.Inject
import javax.inject.Singleton


class ProductRepository
@Inject constructor(private val productApi: ProductApi) : BaseRepository() {
    suspend fun onFetchProduct(idProductType: String) =
        handleResult { productApi.onFetchProduct(idProductType); }

    suspend fun onInsertProduct(product: Product): Result<Product> {
        return handleResult {
            productApi.onInsert(
                product._idTypeProduct,
                product.nameProduct,
                product.price
            )
        }
    }

    suspend fun updateProduct(product: Product): Result<Product> {
        return handleResult {
            productApi.onUpdate(
                product._id,
                product._idTypeProduct,
                product.nameProduct,
                product.price
            )
        }
    }

    suspend fun onDeleteProduct(product: Product){
            productApi.onDelete(product._id)
    }
}