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

class RetrofitClient {

    companion object {
        private val retrofitClient: RetrofitClient =
            RetrofitClient()                           //레트로핏 클라이언트 생성

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }

    private fun buildRetrofit(): RetrofitService {
        val retrofit: Retrofit? = Retrofit.Builder()
            .baseUrl("https://choidaham.com")                   // 서버url
            .addConverterFactory(GsonConverterFactory.create())         // gson으로 받은 값을 레트로핏이 사용할 수 있게 변환하는 과정
            .build()                                                    // 사용할 수 있는 레트로핏 클라이언트를 만듦

        return retrofit!!.create(RetrofitService::class.java)           // 레트로핏 인터페이스 가져오기
    }

    fun requestSignUp(
        uid: String,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val params = HashMap<String?, String?>()
        params["uid"] = uid

        CoroutineScope(Dispatchers.IO).launch {
            val response = buildRetrofit().requestSignUp(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )

                    val jsonObject = JSONObject(prettyJson)
                    if (jsonObject.getString("result") == "success") {
                        success(JSONObject(prettyJson))
                    } else {
                        error(jsonObject.getString("error_code"))
                    }
                } else {
                    error(response.code().toString())
                }
            }
        }
    }

}