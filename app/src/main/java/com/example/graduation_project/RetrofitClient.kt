package com.example.happybirthday

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private val retrofitClient: RetrofitClient = RetrofitClient()//레트로핏 클라이언트 생성

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }

    fun buildRetrofit(): RetrofitService {
        val retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl("http://3.22.100.105:3000/")//서버url
                .addConverterFactory(GsonConverterFactory.create())//gson으로 받은 값을 레트로핏이 사용할 수 있게 변환하는 과정
                .build()//사용할 수 있는 레트로핏 클라이언트를 만듦

        val service: RetrofitService = retrofit!!.create(RetrofitService :: class.java)//레트로핏 인터페이스 가져오기
        return service
    }

    fun getCurrentWeather(lat : String, lon : String,
                          success: (JSONObject) -> Unit,
                          error: (Call<JsonObject>,Throwable) -> Unit) {

        var res: Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getCurrentWeather(lat, lon, "98f72a185ab70464886924c037e07ed0")

        val result = res.enqueue(object: Callback<JsonObject> {

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                error(call,t)
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                success(JSONObject(response.body().toString()))
            }
        })

        return result
    }

    fun getUserInfo(id : String, pw : String,
                success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){

        var idpw: Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getUserInfo(id, pw)

        val result =  idpw.enqueue(object: Callback<JsonObject> {

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                error(call,t)
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                success(JSONObject(response.body().toString()))
            }
        })

        return result

    }

    fun getHello(hel : String, success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){

        val hello : Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getHelloWorld(hel)

        val result = hello.enqueue(object: Callback<JsonObject> {

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                error(call,t)
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                success(JSONObject(response.body().toString()))
            }
        })

        return result

    }

}