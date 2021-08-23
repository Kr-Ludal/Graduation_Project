package com.example.happybirthday

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("weather?")//주소 뒤에 weather이 추가로 입력됨
    fun getCurrentWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("APPID") APPID: String)
            : Call<JsonObject>//lat,lon,APPID라는 이름을 가진 변수들이 ui에서 적은 값들을 읽어와서 저장한 다음 보낸 후 받아온 값을 jsonobject라는 형태를 가진 call에 들어감


    @GET("hello")
        fun getHelloWorld(
            @Query("hello") hel: String)
            : Call<JsonObject>

        @GET("users")
        fun getUserInfo(
                @Query("id") id : String,
                @Query("password") pw : String
        ) : Call<JsonObject>

}

