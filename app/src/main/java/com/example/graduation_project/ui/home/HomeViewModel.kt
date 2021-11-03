package com.example.graduation_project.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Home.HomeRepository
import com.example.graduation_project.data.Home.Result

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _homeDataState = MutableLiveData<ArrayList<HomeModel>>()
    val homeDataState: LiveData<ArrayList<HomeModel>> = _homeDataState

    fun getBoardItem() {
        homeRepository.getBoardData {
            if (it is Result.Success) {
                _homeDataState.value = it.data
            } else if (it is Result.Error) {
            }
        }
    }
}