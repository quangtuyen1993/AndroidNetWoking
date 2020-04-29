package com.example.androidnetwoking.view.main.fragment.homefragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnetwoking.data.model.Product
import com.example.androidnetwoking.data.reponsitory.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel
@Inject constructor(
   private var productRepository: ProductRepository
) : ViewModel() {
    var list = MutableLiveData<MutableList<Product>>()
}