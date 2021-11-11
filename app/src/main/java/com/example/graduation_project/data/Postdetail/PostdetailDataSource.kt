package com.example.graduation_project.data.Postdetail

import android.accounts.NetworkErrorException
import android.util.Log
import com.example.graduation_project.R
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
                val random = (1..8).random()
                val item = jsonArray[i] as JSONObject
                val date = item.get("comment_date").toString()
                val comment = item.get("comment").toString()
                val like = item.get("comment_like") as Int
                val likeCheckable= item.get("comment_liked") as Int//좋아요 클릭 여부
                val comment_uid=item.get("comment_uid") as Int
                val name = item.get("user_id").toString()


                arrayList.add(CommentModel(setProfileImage(random),name,date, comment,like,likeCheckable,comment_uid))

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
    private fun setProfileImage(languageType : Int) : Int{
        var type = 0
        when(languageType){
            1->{type= R.drawable.hongbin}
            2->{type= R.drawable.nico}
            3->{type= R.drawable.seolhyeon}
            4->{type= R.drawable.seahyeong}
            5->{type= R.drawable.gongyou}
            6->{type= R.drawable.nana}
            7->{type= R.drawable.zongseok}
            8->{type= R.drawable.iu}
        }
        return type
    }

}