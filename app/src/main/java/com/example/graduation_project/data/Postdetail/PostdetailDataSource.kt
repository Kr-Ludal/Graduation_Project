package com.example.graduation_project.data.Postdetail

import android.accounts.NetworkErrorException
import android.util.Log
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.Postdetail.PostdetailModel
import org.json.JSONObject

class PostdetailDataSource {

    fun getPostDetail(post_id:Int, result: (Result<String>)->Unit){
        RetrofitClient.getInstance().requestPostdetail(post_id,{

            val maintext = it.get("maintext").toString()

            result(Result.Success(maintext))
        },{
            result(Result.Error(NetworkErrorException()))
        })


    }

}