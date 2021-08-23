package com.example.graduation_project.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Login.LoginDataSource
import com.example.graduation_project.data.Login.LoginRepository
import java.lang.IllegalArgumentException

class LoginViewModelFectory :ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(
                    loginRepository = LoginRepository(dataSource = LoginDataSource())
            )as T//자료형변환LoginViewModel을 Template로 변환하여 자료변환을 쉽게 만들어줌
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}