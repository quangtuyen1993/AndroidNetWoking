package com.example.androidnetwoking.view.login.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.androidnetwoking.R
import com.example.androidnetwoking.databinding.FragmentLoginBinding
import com.example.androidnetwoking.view.login.activity.LoginActivity
import com.example.androidnetwoking.view.login.viewmodel.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import com.example.androidnetwoking.data.reponsitory.Result
import com.example.androidnetwoking.view.main.activity.MainActivity

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    companion object{
        fun newInstance():LoginFragment{
            return LoginFragment();
        }
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var vm: LoginViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val view = binding.root
        vm = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.userLogin = vm
        binding.lifecycleOwner = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.userLogin.observe(viewLifecycleOwner, Observer {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        })
        vm.userLoginError.observe(viewLifecycleOwner, Observer {
            AlertDialog.Builder(activity)
                .setTitle("Error").setMessage(it.message).setPositiveButton("OK", null)
                .show()
        })
    }


}
