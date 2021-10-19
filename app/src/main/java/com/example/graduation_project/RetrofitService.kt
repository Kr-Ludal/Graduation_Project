package com.example.graduation_project

import com.example.graduation_project.ui.login.postJoin
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface RetrofitService {

    @FormUrlEncoded
    @POST("/requestSignUp")
    suspend fun requestSignUp(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @GET("/requestPost")
    suspend fun requestPost() : Response<ResponseBody>

}