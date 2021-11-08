package com.example.graduation_project.ui.Search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Search.SearchDataSource
import com.example.graduation_project.data.Search.SearchRepository
import java.lang.IllegalArgumentException

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)){
            return SearchViewModel(
                searchRepository = SearchRepository(dataSource = SearchDataSource())
            )as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}