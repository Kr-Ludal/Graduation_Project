package com.example.graduation_project.ui.Postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Postdetail.PostdetailRepository
import com.example.graduation_project.data.Postdetail.Result

class PostdetailViewModel(private val postdetailRepository: PostdetailRepository):ViewModel() {

    private val _postdetailDataState = MutableLiveData<String>()
    val postdetailDataState : LiveData<String> = _postdetailDataState

    private val _commentDataState = MutableLiveData<ArrayList<CommentModel>>()
    val commentDataState : LiveData<ArrayList<CommentModel>> = _commentDataState

    fun getPostdetailData(post_id:Int){
        postdetailRepository.getPostdetailData(post_id) {
            if(it is Result.Success){
                _postdetailDataState.value=it.data
            }else{}
        }
    }

    fun getCommentData(post_id: Int){

    }



}