package com.example.androidnetwoking.view.main.viewmodel

import androidx.lifecycle.*
import com.example.androidnetwoking.data.reponsitory.ProductTypeRepository
import com.example.androidnetwoking.data.model.ProductTypes
import com.example.androidnetwoking.data.reponsitory.Result
import com.example.androidnetwoking.util.di.scope.ActivityScope
import com.example.androidnetwoking.view.main.activity.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val productTypeRepository: ProductTypeRepository,
    @ActivityScope
    val activity: MainActivity
) : ViewModel() {
    var list = MutableLiveData<MutableList<ProductTypes>>()
    fun fetchListProductType() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = productTypeRepository.onFetchProductType()
            withContext(Dispatchers.IO) {
                when (res) {
                    is Result.Success ->list.postValue(res.data)
                }
            }
        }
    }


}