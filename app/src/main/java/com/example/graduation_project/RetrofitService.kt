package com.example.graduation_project

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface RetrofitService {

    @FormUrlEncoded
    @POST("/requestSignUp")
    suspend fun requestSignUp(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @GET("/requestmainscreen")
    suspend fun requestMainScreen() : Response<ResponseBody>

}