package com.example.graduation_project.ui.ContestPostdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.ContestPostdetail.ContestPostdetailRepository
import com.example.graduation_project.data.ContestPostdetail.Result

class ContestPostdetailViewModel(private val contestPostdetailRepository: ContestPostdetailRepository)
    :ViewModel(){
        private val _contestPostDataState = MutableLiveData<String>()
        val contestPostDataState: LiveData<String> = _contestPostDataState

        fun getContestData(post_id:Int){
            contestPostdetailRepository.getContestData {
                if(it is Result.Success){

                }
            }
        }


}