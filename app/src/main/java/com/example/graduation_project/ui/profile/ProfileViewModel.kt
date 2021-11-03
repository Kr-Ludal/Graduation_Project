package com.example.graduation_project.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Profile.ProfileRepository
import com.example.graduation_project.ui.contest.ContestModel
import com.example.graduation_project.ui.home.HomeModel

class ProfileViewModel(private val profileRepository: ProfileRepository) : ViewModel(){

    private val _profileCodeDataState = MutableLiveData<ArrayList<HomeModel>>()
    val profileCodeDataState : LiveData<ArrayList<HomeModel>> = _profileCodeDataState

    private val _profileSolutionDataState = MutableLiveData<ArrayList<ContestModel>>()
    val profileSolutionDataState : LiveData<ArrayList<ContestModel>> = _profileSolutionDataState



}