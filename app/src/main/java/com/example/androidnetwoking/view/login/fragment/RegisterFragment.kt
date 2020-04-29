package com.example.androidnetwoking.view.login.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import com.example.androidnetwoking.R
import com.example.androidnetwoking.databinding.FragmentLoginBinding
import com.example.androidnetwoking.databinding.FragmentRegisterBinding
import com.example.androidnetwoking.view.login.viewmodel.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {
    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
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
        val binding: FragmentRegisterBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        val view = binding.root
        vm = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.userLogin = vm
        binding.lifecycleOwner = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.userRegister.observe(viewLifecycleOwner, Observer {
          buildDialog("Success","Hello"+it.username)

        })
        vm.userLoginError.observe(viewLifecycleOwner, Observer {
            buildDialog("Error", "Sorry ${it.message}")
        })

    }

    private fun buildDialog(title: String, message: String) {
        AlertDialog.Builder(activity).setTitle(title).setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

}
