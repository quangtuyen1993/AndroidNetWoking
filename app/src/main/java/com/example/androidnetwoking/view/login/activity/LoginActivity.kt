package com.example.androidnetwoking.view.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidnetwoking.R
import com.example.androidnetwoking.view.login.viewmodel.LoginViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject
import  com.example.androidnetwoking.data.reponsitory.Result
import com.example.androidnetwoking.view.login.fragment.LoginFragment
import dagger.android.support.DaggerAppCompatActivity

class LoginActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction()
            .add(R.id.fr_login, LoginFragment.newInstance())
            .commit()
    }
}
