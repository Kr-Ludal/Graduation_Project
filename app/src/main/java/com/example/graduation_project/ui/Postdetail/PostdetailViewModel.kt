package com.example.graduation_project.ui.Postdetail

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.R
import com.example.graduation_project.data.Postdetail.PostdetailRepository
import com.example.graduation_project.data.Postdetail.Result

class PostdetailViewModel(private val postdetailRepository: PostdetailRepository):ViewModel() {

    private val _postdetailDataState = MutableLiveData<String>()
    val postdetailDataState : LiveData<String> = _postdetailDataState

    private val _commentDataState = MutableLiveData<ArrayList<CommentModel>>()
    val commentDataState : LiveData<ArrayList<CommentModel>> = _commentDataState

    private val _commentForm = MutableLiveData<Boolean>()
    val commentFormState : LiveData<Boolean> = _commentForm

    fun getPostdetailData(post_id:Int){
        postdetailRepository.getPostdetailData(post_id) {
            if(it is Result.Success){
                _postdetailDataState.value=it.data
            }else{}
        }
    }

    fun postCommentData(comment:String,post_id : Int){
        postdetailRepository.postCommentData(comment,post_id){
            if(it is Result.Success){

            } else{

            }
        }
    }

    fun getCommentData(post_id: Int){
        postdetailRepository.getCommentData(post_id){
            if(it is Result.Success){
                _commentDataState.value=it.data
            }
        }
    }

    fun loginDataChanged(comment: String) {
        _commentForm.value = isCommentValid(comment)
    }
    private fun isCommentValid(comment: String): Boolean {
        return comment.isNotBlank()

    }

}