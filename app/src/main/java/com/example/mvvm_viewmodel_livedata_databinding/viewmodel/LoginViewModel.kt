package com.example.mvvm_viewmodel_livedata_databinding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_viewmodel_livedata_databinding.model.User
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Patterns
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class LoginViewModel:ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    var btnSelected =  MutableLiveData<Boolean>()
    var  userMutableLiveData: MutableLiveData<User>? = null




    fun getUser(): MutableLiveData<User> {

        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData as MutableLiveData<User>

    }



    fun isEmailValid(): Boolean {
        return EmailAddress.value != null && Patterns.EMAIL_ADDRESS.matcher(EmailAddress.value).matches()
    }


    fun isPasswordLengthGreaterThan5(): Boolean {
        return Password.value != null && Password.value.toString().length > 5
    }


    fun onClick(view: View) {

        val loginUser = User(EmailAddress.value, Password.value)
        userMutableLiveData?.value = loginUser

    }


}