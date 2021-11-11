package com.example.graduation_project.data.Postdetail

import android.accounts.NetworkErrorException
import android.util.Log
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.Postdetail.CommentModel
import com.example.graduation_project.ui.Postdetail.PostdetailModel
import org.json.JSONObject

class PostdetailDataSource {

    private var commentDataSource = ArrayList<CommentModel>()

    fun getPostDetail(post_id:Int, result: (Result<String>)->Unit){
        RetrofitClient.getInstance().requestPostdetail(post_id,{
            val maintext = it.get("maintext").toString()
            result(Result.Success(maintext))
        },{
            result(Result.Error(NetworkErrorException()))
        })
    }

    fun getCommentData(post_id: Int,result: (Result<ArrayList<CommentModel>>) -> Unit){
        RetrofitClient.getInstance().getCommentData(post_id,{
            val jsonArray = it.getJSONArray("comment")
            val arrayList= mutableListOf<CommentModel>()
            Log.d("postdetailDataSource", "getCommentData: success")
            for(i in 0 until jsonArray.length()){
                val item = jsonArray[i] as JSONObject
                val date = item.get("comment_date").toString()
                val comment = item.get("comment").toString()
                val like = item.get("comment_like") as Int
                val likeCheckable= item.get("comment_liked") as Int//좋아요 클릭 여부
                val comment_uid=item.get("comment_uid") as Int
                val name = item.get("user_id").toString()


                arrayList.add(CommentModel(name,date, comment,like,likeCheckable,comment_uid))

            }
            commentDataSource= arrayList as ArrayList<CommentModel>
            result(Result.Success(commentDataSource))
        },{
            result(Result.Error(NetworkErrorException()))
            Log.d("postdetailDataSource", "getCommentData: fail ${NetworkErrorException()}")
        })
    }

    fun postCommentData(comment:String,post_id:Int, result: (Result<String>) -> Unit){
        RetrofitClient.getInstance().postCommentData(comment,post_id,{
            Log.d("postdetailDataSource", "postCommentData: Success")
        },{
            Log.d("postdetailDataSource", "postCommentData: Fail")
            result(Result.Error(NetworkErrorException()))
        })
    }

    fun postCommentLike(comment_uid:Int,comment_liked:Int,result: (Result<String>) -> Unit){

    }

}