package com.example.graduation_project.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Bookmark.BookmarkRepository
import com.example.graduation_project.data.Bookmark.Result
import com.example.graduation_project.ui.home.HomeModel

class BookmarkViewModel(private val bookmarkRepository: BookmarkRepository): ViewModel() {

    private val _bookmarkDataState = MutableLiveData<ArrayList<HomeModel>>()
    val bookmarkDataState: LiveData<ArrayList<HomeModel>> = _bookmarkDataState

    fun getBookmarkItem(){
        bookmarkRepository.getBookmarkData(){
            if(it is Result.Success){
                _bookmarkDataState.value=it.data
            }
        }
    }

}