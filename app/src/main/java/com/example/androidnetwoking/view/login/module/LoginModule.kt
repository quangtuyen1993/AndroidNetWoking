package com.example.androidnetwoking.view.login.module

import androidx.lifecycle.ViewModel
import com.example.androidnetwoking.util.di.scope.ViewModelKey
import com.example.androidnetwoking.view.login.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel):ViewModel

}