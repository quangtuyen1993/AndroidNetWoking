package com.example.androidnetwoking.view.login.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import com.example.androidnetwoking.data.model.Customer
import com.example.androidnetwoking.data.model.MessageError
import com.example.androidnetwoking.data.reponsitory.CustomerRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.androidnetwoking.data.reponsitory.Result
import com.example.androidnetwoking.util.di.scope.ActivityScope
import com.example.androidnetwoking.view.login.activity.LoginActivity
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import com.example.androidnetwoking.R
import com.example.androidnetwoking.view.login.fragment.RegisterFragment

class LoginViewModel
@Inject constructor(
    private var customerRepository: CustomerRepository,
    @ActivityScope
    var activity: LoginActivity
) : ViewModel() {
    //use fragment login
    var username: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()

    //userlogin
    var userLogin: MutableLiveData<Customer> = MutableLiveData()


    var userLoginError: MutableLiveData<MessageError> = MutableLiveData();
    fun onLogin() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                var result = customerRepository.onUserLogin(
                    username = username.value!!,
                    password = password.value!!
                )
                when (result) {
                    is Result.Error<Customer> -> userLoginError.postValue(result.message)
                    is Result.Success<Customer> -> userLogin.postValue(result.data)
                }
            }
        } catch (e: Exception) {
            Log.e("Main", e.toString())
        }
    }

    fun changeFragmentRegister() {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fr_login, RegisterFragment.newInstance())
            .addToBackStack("LoginFragment")
            .commit()
    }


    //use fragment register
    //userRegister
    var userRegister: MutableLiveData<Customer> = MutableLiveData();
    var usernameRegister: MutableLiveData<String> = MutableLiveData()
    var passwordRegister: MutableLiveData<String> = MutableLiveData()
    var passwordConfirm: MutableLiveData<String> = MutableLiveData()
    fun changeFragmentLogin() {
        activity.supportFragmentManager.popBackStack("LoginFragment", 1)
    }

    fun onRegister() {
        Log.e("Main",passwordRegister.value+" "+passwordConfirm.value)
        if (!passwordRegister.value.equals(passwordConfirm.value) ) {
            userLoginError.postValue(MessageError("Password confirm incorrect"))
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val req =
                    customerRepository.onRegister(
                        username = usernameRegister.value!!,
                        password = passwordRegister.value!!
                    )
                when (req) {
                    is Result.Success -> userRegister.postValue(req.data)
                    is Result.Error -> userLoginError.postValue(req.message)
                }

            }
        }
    }

}