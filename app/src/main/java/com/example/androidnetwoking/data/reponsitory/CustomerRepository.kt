package com.example.androidnetwoking.data.reponsitory

import com.example.androidnetwoking.api.CustomerApi
import com.example.androidnetwoking.data.model.Customer
import javax.inject.Inject

class CustomerRepository
@Inject constructor(private var customerApi: CustomerApi) : BaseRepository() {
    suspend fun onUserLogin(username: String, password: String):Result <Customer> =
        handleResult { customerApi.onLogin(username, password) }

    suspend fun onRegister(username: String,password: String):Result<Customer> =
        handleResult { customerApi.onRegister(username,password) }
}
