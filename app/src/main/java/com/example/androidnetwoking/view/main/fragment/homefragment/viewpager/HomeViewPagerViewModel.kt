package com.example.androidnetwoking.view.main.fragment.homefragment.viewpager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnetwoking.data.model.Product
import com.example.androidnetwoking.data.model.ProductTypes
import com.example.androidnetwoking.data.reponsitory.ProductRepository
import com.example.androidnetwoking.data.reponsitory.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewPagerViewModel
@Inject constructor(private var productRepository: ProductRepository) : ViewModel() {

    lateinit var productTypes: ProductTypes

    private var idType: MutableLiveData<String> = MutableLiveData()
    var nameProduct: MutableLiveData<String> = MutableLiveData()
    var price: MutableLiveData<Int> = MutableLiveData();
    var products: MutableLiveData<MutableList<Product>> = MutableLiveData()

    private var idProduct: MutableLiveData<String> = MutableLiveData();

    fun onFetchList(productType: ProductTypes) {
        this.productTypes = productType

        idType.postValue(productType._id)
        viewModelScope.launch(Dispatchers.IO) {
            val res = productRepository.onFetchProduct(productType._id!!)
            withContext(Main) {
                when (res) {
                    is Result.Success -> products.postValue(res.data)
                }
            }
        }
    }

    fun onShowInsert() {
        idProduct.postValue("")
        nameProduct.postValue("")
        price.postValue(0)
    }

    fun onShowItemUpdate(product: Product) {
        idProduct.postValue(product._id)
        idType.postValue(product._idTypeProduct)
        nameProduct.postValue(product.nameProduct)
        price.postValue(product.price)
    }

    fun onUpdateProduct() {
        val product = Product(
            idProduct.value!!,
            idType.value!!,
            nameProduct.value!!,
            "",
            price.value!!
        )
        onUpdate(product)
    }


    fun onInsertProduct() {
        val product = Product(
            idType.value!!,
            nameProduct.value!!,
            "",
            price = price.value!!
        )
        onInsert(product)
    }

    private fun onInsert(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = productRepository.onInsertProduct(product)
            withContext(Main) {
                when (res) {
                    is Result.Success -> onFetchList(productTypes)
                }
            }
        }
    }

    private fun onUpdate(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = productRepository.updateProduct(product)
            withContext(Main) {
                when (res) {
                    is Result.Success -> onFetchList(productTypes)
                }
            }
        }
    }

    fun onDelete(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.onDeleteProduct(product);
            onFetchList(productTypes)
        }
    }
}