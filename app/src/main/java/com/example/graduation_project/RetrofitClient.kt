package com.example.graduation_project

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
        private val retrofitClient: RetrofitClient = RetrofitClient()                           //레트로핏 클라이언트 생성

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }

    fun buildRetrofit(): RetrofitService {
        val retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl("https://choidaham.com/")                    //서버url
                .addConverterFactory(GsonConverterFactory.create())                         //gson으로 받은 값을 레트로핏이 사용할 수 있게 변환하는 과정
                .build()                                                                    //사용할 수 있는 레트로핏 클라이언트를 만듦

        val service: RetrofitService = retrofit!!.create(RetrofitService :: class.java)     //레트로핏 인터페이스 가져오기

        return service
    }



    fun getUserInfo(email : String, pw : String,
                    success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){


        var idpw: Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getUserInfo(email,pw)
        Log.d("tag", "id : ${email},pw : ${pw}")
//
//        val interceptor=HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val interceptorclient = OkHttpClient()
//                .newBuilder()
//                .addNetworkInterceptor(interceptor)
//                .build()

        //interceptorclient
        val result =  idpw.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                success(JSONObject(response.body().toString()))

                Log.d("TAG", "onResponse: 성공")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                error(call, t)
                Log.d("TAG", "onFailure: 실패")
            }


        })

        return result

    }


    fun getuser(id:String,pw:String, success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){

        val res : Call<JsonObject> = RetrofitClient.getInstance().buildRetrofit().getuser(RetrofitService.reqLogin(id,pw))


        val result =res.enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

    }

    fun getHomeBoardData(success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){

        val feeds : Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getHomeBoardData()

        val result =feeds.enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                success(JSONObject(response.body().toString()))
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

        return result

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



}