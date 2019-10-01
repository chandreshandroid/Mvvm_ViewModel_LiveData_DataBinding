package com.example.mvvm_viewmodel_livedata_databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_viewmodel_livedata_databinding.R
import com.example.mvvm_viewmodel_livedata_databinding.databinding.ActivityMainBinding
import com.example.mvvm_viewmodel_livedata_databinding.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

  lateinit  var loginViewModel:LoginViewModel
    lateinit  var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //create loginViewModel

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.viewmodel=loginViewModel


        loginViewModel.getUser().observe(this, Observer {


            if(!loginViewModel.isEmailValid() ) {
                binding.txtEmailAddress.error = "Enter a Valid E-mail Address"
                binding.txtEmailAddress.requestFocus()
            } else if(!loginViewModel.isPasswordLengthGreaterThan5()) {
                binding.txtPassword.error = "Enter at least 6 Character password"
                binding.txtPassword.requestFocus()
            } else {
                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            }


        })




    }
}
