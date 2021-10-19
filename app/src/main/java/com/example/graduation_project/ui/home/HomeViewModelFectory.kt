package com.example.graduation_project.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Home.HomeDataSource
import com.example.graduation_project.data.Home.HomeRepository
import java.lang.IllegalArgumentException

class HomeViewModelFectory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(
                homeRepository = HomeRepository(dataSource = HomeDataSource())
            )as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}