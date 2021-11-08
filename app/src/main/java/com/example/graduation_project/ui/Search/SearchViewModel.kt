package com.example.graduation_project.ui.Search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Search.SearchRepository
import com.example.graduation_project.ui.home.HomeModel
import com.example.graduation_project.data.Search.Result
class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _searchDataState=MutableLiveData<ArrayList<HomeModel>>()
    val searchDataState : LiveData<ArrayList<HomeModel>> = _searchDataState

    fun getSearchItem(inputData:String){
        searchRepository.getSearchData(inputData){
            if(it is Result.Success){
                _searchDataState.value=it.data
            }
        }
    }

}