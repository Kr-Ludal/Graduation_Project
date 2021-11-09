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
            val jsonArray = it.getJSONArray("date")
            val arrayList= mutableListOf<CommentModel>()

            for(i in 0 until jsonArray.length()){
                val item = jsonArray[i] as JSONObject
                val name = item.get("nickname").toString()
                val date = item.get("Comment_date").toString()
                val comment = item.get("Comment").toString()
                val like = item.get("") as Int
                val likeCheckable= item.get("") as Int
                arrayList.add(CommentModel(name,date, comment,like,likeCheckable))
            }
            commentDataSource= arrayList as ArrayList<CommentModel>
            result(Result.Success(commentDataSource))
        },{
            result(Result.Error(NetworkErrorException()))
            Log.d("postdetailDataSource", "getCommentData: fail")
        })
    }

    fun postCommentData(comment:String,post_id:Int, result: (Result<String>) -> Unit){
        RetrofitClient.getInstance().postCommentData(comment,post_id,{
            Log.d("postdetailDataSource", "postCommentData: Success")
        },{
            Log.d("postdetailDataSource", "postCommentData: Fail")
        })

    }

}