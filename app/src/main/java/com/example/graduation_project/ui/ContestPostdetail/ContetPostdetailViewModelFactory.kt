package com.example.graduation_project.ui.ContestPostdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.ContestPostdetail.ContestPostdetailDataSource
import com.example.graduation_project.data.ContestPostdetail.ContestPostdetailRepository
import java.lang.IllegalArgumentException

class ContetPostdetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContestPostdetailViewModel::class.java)) {
            return ContestPostdetailViewModel(
                contestPostdetailRepository =
                ContestPostdetailRepository(dataSource = ContestPostdetailDataSource())
            )as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}