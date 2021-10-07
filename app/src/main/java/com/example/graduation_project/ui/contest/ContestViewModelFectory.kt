package com.example.graduation_project.ui.contest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Contest.ContestDataSource
import com.example.graduation_project.data.Contest.ContestRepository
import java.lang.IllegalArgumentException

class ContestViewModelFectory :ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContestViewModel::class.java)){
            return ContestViewModel(
                    contestRepository = ContestRepository(dataSource = ContestDataSource())
            ) as T//자료형변환LoginViewModel을 Template로 변환하여 자료변환을 쉽게 만들어줌
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}