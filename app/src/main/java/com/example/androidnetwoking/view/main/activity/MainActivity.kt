package com.example.androidnetwoking.view.main.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidnetwoking.R
import com.example.androidnetwoking.view.main.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity :DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        var vm=ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]


        setContentView(R.layout.activity_main)
        setUpNavigation();
    }
    private fun setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment!!.navController
        )
    }
}


