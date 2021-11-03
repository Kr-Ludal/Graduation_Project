package com.example.graduation_project.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Profile.ProfileDataSource
import com.example.graduation_project.data.Profile.ProfileRepository
import java.lang.IllegalArgumentException

class ProfileViewModelFactory :ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(
                profileRepository = ProfileRepository(dataSource = ProfileDataSource())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}