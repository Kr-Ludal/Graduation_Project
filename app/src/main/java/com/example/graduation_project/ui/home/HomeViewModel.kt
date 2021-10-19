package com.example.graduation_project.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Home.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _homeDataState = MutableLiveData<ArrayList<HomeModel>>()
    val homeDataState : LiveData<ArrayList<HomeModel>> = _homeDataState

    fun getBoardItem() {
        val result = homeRepository.getBoardData()
        _homeDataState.value=result
    }


}