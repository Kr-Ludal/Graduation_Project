package com.example.graduation_project

import com.example.graduation_project.ui.login.postJoin
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface RetrofitService {

<<<<<<< HEAD

    @GET("weather")//주소 뒤에 weather이 추가로 입력됨
    fun getCurrentWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("APPID") APPID: String)
            : Call<JsonObject>
    //lat,lon,APPID라는 이름을 가진 변수들이 ui에서 적은 값들을 읽어와서 저장한 다음 보낸 후 받아온 값을 jsonobject라는 형태를 가진 call에 들어감

//
//    @GET("requestLogin")
//    fun getUserInfo(
//            @Query("email") email : String,
//            @Query("password") password : String
//    ) : Call<JsonObject>
//
//    @FormUrlEncoded
//    @POST("requestLogin")
//    fun getUserInfo(
//            @Body email : String,
//            @Body password : String
//    ) : Call<JsonObject>
//
//    @FormUrlEncoded
//    @POST("requestLogin")
//    fun getUserInfo(
//            @Field("email") email : String,
//            @Field("password") password : String
//    ) : Call<JsonObject>


    data class reqLogin(val email: String, val password: String)


    @POST("requestLogin")
    fun getusers(
            @Body info: reqLogin
    ): Call<JsonObject>

    @FormUrlEncoded
    @POST("/response-headers")
    suspend fun postpost(
            @Field("freeform") params: String
    ): Response<ResponseBody>


    @POST("requestLogin")
    fun getUser(
            @Body info: reqLogin
    ): Call<reqLogin>

    @GET("RequestMainScreen")
    fun getHomeBoardData(
    ): Call<JsonObject>

    @POST("RequestJoin")
    fun postUserInfo(
            @Body info: postJoin
    ): Call<JsonObject>


=======
    @GET("/requestSignUp")
    suspend fun requestSignUp(
        @Query("uid") uid: String
    ): Response<ResponseBody>

>>>>>>> 04420ed856f004e3a72b131d2a1d34e12c224c8d
}