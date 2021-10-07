package com.example.graduation_project

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {


    @GET("weather")//주소 뒤에 weather이 추가로 입력됨
    fun getCurrentWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("APPID") APPID: String)
            : Call<JsonObject>//lat,lon,APPID라는 이름을 가진 변수들이 ui에서 적은 값들을 읽어와서 저장한 다음 보낸 후 받아온 값을 jsonobject라는 형태를 가진 call에 들어감


//    @GET("requestLogin")
//    fun getUserInfo(
//            @Query("email") email : String,
//            @Query("password") password : String
//    ) : Call<JsonObject>

//    @FormUrlEncoded
//    @POST("requestLogin")
//    fun getUserInfo(
//            @Body email : String,
//            @Body password : String
//    ) : Call<JsonObject>

    data class reqLogin (val email: String,val password : String)


    @POST("requestLogin")
    fun getUserInfo(
            @Body email : String,
            @Body password : String
    ) : Call<JsonObject>


    @POST("requestLogin")
    fun getuser(
            @Body info:reqLogin
    ) : Call<JsonObject>


    @GET("RequestMainScreen")
    fun getHomeBoardData(
    ) : Call<JsonObject>



}