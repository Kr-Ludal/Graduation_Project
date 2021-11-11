package com.example.graduation_project.data.Postdetail

import com.example.graduation_project.ui.Postdetail.CommentModel
import com.example.graduation_project.ui.Postdetail.PostdetailModel

class PostdetailRepository(val dataSource: PostdetailDataSource) {

    fun getPostdetailData(post_id : Int, result: (Result<String>)->Unit){
        dataSource.getPostDetail(post_id,result)
    }

    fun getCommentData(post_id: Int,result: (Result<ArrayList<CommentModel>>) -> Unit){
        dataSource.getCommentData(post_id,result)
    }

    fun postCommentData(comment : String, post_id:Int,result: (Result<String>) -> Unit){
        dataSource.postCommentData(comment,post_id,result)
    }


}