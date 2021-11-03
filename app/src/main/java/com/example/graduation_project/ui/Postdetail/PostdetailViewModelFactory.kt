package com.example.graduation_project.ui.Postdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Postdetail.PostdetailDataSource
import com.example.graduation_project.data.Postdetail.PostdetailRepository
import java.lang.IllegalArgumentException

class PostdetailViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostdetailViewModel::class.java)){
            return PostdetailViewModel(
                postdetailRepository = PostdetailRepository(dataSource = PostdetailDataSource())
            )as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}