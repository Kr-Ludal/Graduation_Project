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
    @FormUrlEncoded
    @POST("/requestmainscreen")
    suspend fun requestMainScreen(@Field("user_id") userId: String): Response<ResponseBody>
    //MainScreen Area End

    //Bookmark Area
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
    //Bookmark Area End

    //Contest Area
    @GET("/requestcontestscreen")
    suspend fun requestContestScreen(): Response<ResponseBody>
    //Contest Area End

    //Postdetail Area
    @GET("/getDetailPostResult")
    suspend fun requestPostDetail(@Query("post_id") post_id: Int): Response<ResponseBody>
    //Postdetail Area End

    //BookMark Area
    @FormUrlEncoded
    @POST("/reqBookmark")
    suspend fun requestBookmark(@Field("user_id") user_id: String): Response<ResponseBody>

    //Write Area
    @FormUrlEncoded
    @POST("/PostWrite")
    suspend fun postWriteData(
        @Field("user_id") user_id: String,
        @Field("subtext") title: String,
        @Field("maintext") content: String,
        @Field("tag") tag:String,
        @Field("language_type") languageType: Int
    ): Response<ResponseBody>

    //Search Area
    @FormUrlEncoded
    @POST("/reqsearch")
    suspend fun postSearchData(
        @Field("user_id") user_id: String,
        @Field("search_data") search_data:String
    ): Response<ResponseBody>

    //Comment Area
    @FormUrlEncoded
    @POST("postComment")
    suspend fun postCommentData(
        @Field("user_id") user_id:String,
        @Field("post_id") post_id: Int
    ):Response<ResponseBody>


}