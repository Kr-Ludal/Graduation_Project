package com.example.graduation_project.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Bookmark.BookmarkDataSource
import com.example.graduation_project.data.Bookmark.BookmarkRepository
import java.lang.IllegalArgumentException

class BookmarkViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookmarkViewModel::class.java)){
            return BookmarkViewModel(
                bookmarkRepository = BookmarkRepository(dataSource = BookmarkDataSource())
            )as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}