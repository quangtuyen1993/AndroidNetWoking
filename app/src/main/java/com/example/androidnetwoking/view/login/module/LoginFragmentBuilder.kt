package com.example.androidnetwoking.view.login.module

import androidx.fragment.app.Fragment
import com.example.androidnetwoking.util.di.scope.FragmentScope
import com.example.androidnetwoking.view.login.fragment.LoginFragment
import com.example.androidnetwoking.view.login.fragment.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentBuilder (){
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindLoginFragment():LoginFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindRegisterFragment():RegisterFragment
}