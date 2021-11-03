package com.example.graduation_project

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface RetrofitService {
    //Login Area
    @FormUrlEncoded
    @POST("/requestSignUp")
    suspend fun requestSignUp(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>
    //Login Area End

    //MainScreen Area
    @GET("/requestmainscreen")
    suspend fun requestMainScreen(@Query("user_id") userId: String): Response<ResponseBody>

    @FormUrlEncoded
    @POST("/postBookmark")
    suspend fun requestMainBookmark(
        @Field("user_id") userId: String,
        @Field("post_id") postId: Int
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("/cancleBookmark")
    suspend fun requestremoveMainBookmark(
        @Field("post_id") postId: Int,
        @Field("user_id") userId: String
    ): Response<ResponseBody>
    //MainScreen Area End

    //Contest Area
    @GET("/requestcontestscreen")
    suspend fun requestContestScreen(): Response<ResponseBody>
    //Contest Area End

    //Postdetail Area
    @GET("/getDetailPostResult")
    suspend fun requestPostDetail(@Query("post_id") post_id: Int): Response<ResponseBody>
    //Postdetail Area End

    //BookMark Area
    @GET("/reqBookmark")
    suspend fun requestBookmark(@Query("user_id") user_id: String): Response<ResponseBody>
}