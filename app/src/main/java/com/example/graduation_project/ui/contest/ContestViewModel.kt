package com.example.graduation_project.ui.contest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Contest.ContestRepository
import com.example.graduation_project.data.Contest.Result

class ContestViewModel(private val contestRepository: ContestRepository) : ViewModel() {

    private  val _contestDataState = MutableLiveData<ArrayList<ContestModel>>()
    val contestDataState : LiveData<ArrayList<ContestModel>> = _contestDataState

    fun getContestItem() {
        contestRepository.getContestData {
            if (it is Result.Success) {
                _contestDataState.value = it.data
            } else if (it is Result) {
            }
        }
    }

}