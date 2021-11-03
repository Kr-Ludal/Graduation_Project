package com.example.graduation_project.data.Postdetail

import android.accounts.NetworkErrorException
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.Postdetail.PostdetailModel

class PostdetailDataSource {

    fun getPostDetail(post_id:Int, result: (Result<ArrayList<PostdetailModel>>)->Unit){
        RetrofitClient.getInstance().requestPostdetail(post_id,{
            val jsonArray = it.getJSONObject("")
        },{
            result(Result.Error(NetworkErrorException()))
        })


    }

}