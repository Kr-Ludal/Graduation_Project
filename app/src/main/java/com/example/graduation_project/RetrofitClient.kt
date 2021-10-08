package com.example.graduation_project

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class RetrofitClient {

    companion object {
        private val retrofitClient: RetrofitClient = RetrofitClient()                           //레트로핏 클라이언트 생성

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }

    fun buildRetrofit(): RetrofitService {
        val retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl("https://httpbin.org/")                    //서버url
                .addConverterFactory(GsonConverterFactory.create())                         //gson으로 받은 값을 레트로핏이 사용할 수 있게 변환하는 과정
                .build()                                                                    //사용할 수 있는 레트로핏 클라이언트를 만듦

        val service: RetrofitService = retrofit!!.create(RetrofitService :: class.java)     //레트로핏 인터페이스 가져오기

        return service
    }


//
//    fun getUserInfo(email : String, pw : String,
//                    success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){
//
//
//        var idpw: Call<JsonObject> = RetrofitClient
//                .getInstance()
//                .buildRetrofit()
//                .getUserInfo(email,pw)
//        Log.d("tag", "id : ${email},pw : ${pw}")
//
//        val result =  idpw.enqueue(object : Callback<JsonObject> {
//
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                //success(JSONObject(response.body().toString()))
//
//                Log.d("TAG", "onResponse: 성공")
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                error(call, t)
//                Log.d("TAG", "onFailure: 실패")
//            }
//
//
//        })
//
//        return result
//
//    }

    fun postpost(error: (Call<JsonObject>, Throwable) -> Unit, success: (JSONObject) -> Unit){
//
//        var body = HashMap<String?,String?>()
//        body["freeform"] = "abcd"

        CoroutineScope(Dispatchers.IO).launch {
            // Create Retrofit
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://httpbin.org/")
                            .build()

                            // Create Service
                            val service = retrofit.create(RetrofitService::class.java)
            // Do the POST request and get response
            val response = service.postpost("body")

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = response.body().toString()

                    Log.d("Pretty Printed JSON :", prettyJson)

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }

//        val res : Call<JsonObject> = RetrofitClient
//                .getInstance()
//                .buildRetrofit()
//                .postpost(body)
//
//        val result = res.enqueue(object : Callback<JsonObject> {
////            override fun onResponse(call: Call<String>, response: Response<String>) {
////                Log.d("TAG", "onResponse: ${response.body().toString()}")
////            }
////
////            override fun onFailure(call: Call<String>, t: Throwable) {
////
////            }
//
//
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                Log.d("TAG", "onResponse: ${response.body().toString()}")
//
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//
//            }
//
//
////            override fun onResponse(call: Call<OriginDataClass>, response: Response<OriginDataClass>) {
////                Log.d("TAG", "onResponse: ${response.body().toString()}")
////            }
////
////            override fun onFailure(call: Call<OriginDataClass>, t: Throwable) {
////
////            }
//
//
////            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
////                Log.d("TAG", "onResponse: ${response.body().toString()}")
////            }
////
////            override fun onFailure(call: Call<DataClass>, t: Throwable) {
////
////            }
//
//
//        })
//        return result

    }

    fun getUser(id : String, password: String, success: (JSONObject) -> Unit,
                error: (Call<JsonObject>, Throwable) -> Unit){

        val res : Call<RetrofitService.reqLogin> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getUser(RetrofitService.reqLogin(id,password))

        val result = res.enqueue(object : Callback<RetrofitService.reqLogin> {


            override fun onResponse(call: Call<RetrofitService.reqLogin>,
                                    response: Response<RetrofitService.reqLogin>) {

                Log.d("TAG", "onResponse: 성공")
            }

            override fun onFailure(call: Call<RetrofitService.reqLogin>, t: Throwable) {

                Log.d("TAG", "onFailure: 실패")
            }


        })
    return result
    }


    fun getusers(id:String,pw:String, success: (JSONObject) -> Unit,
                 error: (Call<JsonObject>, Throwable) -> Unit){

        val res : Call<JsonObject> = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getusers(RetrofitService.reqLogin(id,pw))


        val result =res.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                //success(JSONObject(response.body().toString()) )
                Log.d("TAG", "onResponse: 성공")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                Log.d("TAG", "onFailure: 실패")
            }


        })
        return result
    }

    fun getHomeBoardData(success: (JSONObject) -> Unit,
                         error: (Call<JsonObject>, Throwable) -> Unit){

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

    data class postJoin(val email : String, val password : String, val nickname : String)
//
//    fun postUserInfo(email : String, password : String, nickname:String,
//                     success: (JSONObject) -> Unit, error: (Call<JsonObject>, Throwable) -> Unit){
//
//        val res : Call<JsonObject> = RetrofitClient
//                .getInstance()
//                .buildRetrofit()
//                .postUserInfo(RetrofitService.postJoin(email,password,nickname))
//
//        val result = res.enqueue(object : Callback<JsonObject>{
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//
//        })
//
//
//        return result
//    }



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