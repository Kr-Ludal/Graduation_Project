package com.example.graduation_project.ui.Register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Register.RegisterDataSource
import com.example.graduation_project.data.Register.RegisterRepository

import java.lang.IllegalArgumentException

class RegisterViewModelFectory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(
                registerRepository = RegisterRepository(dataSource = RegisterDataSource())
            ) as T//자료형변환LoginViewModel을 Template로 변환하여 자료변환을 쉽게 만들어줌
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}