package com.example.graduation_project

import android.os.Debug
import android.util.Log
import com.example.graduation_project.ui.home.HomeModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.w3c.dom.Comment
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

    //MainScreen Area===============================================
    fun requestMainScreen(success: (JSONObject) -> Unit, error: (String) -> Unit) {

        val service = buildRetrofit()
        val userId = Firebase.auth.currentUser?.uid.toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.requestMainScreen(userId)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                        //JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else {
                    error(response.code().toString())
                }
            }
        }
    }

    fun addMainScreenBookmark(
        postId: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val userId = Firebase.auth.currentUser?.uid.toString()
        Log.d("retrofitClient addMainScreen Bookmark", "$userId, $postId")
        if (userId != null) {
            val service = buildRetrofit()
            CoroutineScope(Dispatchers.IO).launch {
                val response = service.requestMainBookmark(userId, postId)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val gson = GsonBuilder().setPrettyPrinting().create()
                        val prettyJson = gson.toJson(
                            JsonParser.parseString(response.body()?.string())
                        )
                        success(JSONObject(prettyJson))
                    } else {
                        error(response.code().toString())
                    }
                }
            }
        }
    }

    fun removeMainScreenBookmark(
        postId: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val userId = Firebase.auth.currentUser?.uid.toString()
        if (userId != null) {
            val service = buildRetrofit()
            CoroutineScope(Dispatchers.IO).launch {
                val response = service.requestremoveMainBookmark(postId, userId)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val gson = GsonBuilder().setPrettyPrinting().create()
                        val prettyJson = gson.toJson(
                            JsonParser.parseString(response.body()?.string())
                        )
                        success(JSONObject(prettyJson))
                    } else {
                        error(response.code().toString())
                    }
                }
            }
        }
    }
    //MainScreen Area End==================================================

    //Comment Area=========================================================

    fun postCommentData(
        comment: String,
        post_id: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.postCommentData(comment, user_id, post_id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else {
                    error(response.code().toString())
                }
            }
        }
    }

    fun getCommentData(postId: Int, success: (JSONObject) -> Unit, error: (String) -> Unit) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getCommentData(user_id, postId)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    Log.d("TAG", "getCommentData: $prettyJson")
                    success(JSONObject(prettyJson))
                } else {
                    error(response.code().toString())
                }
            }
        }
    }

    fun postCommentLike(
        comment_uid: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.postCommentLike(user_id,comment_uid)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else
                    error(response.code().toString())
            }
        }
    }
    fun cancelCommentLike(
        comment_uid: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.cancelCommentLike(user_id,comment_uid)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else
                    error(response.code().toString())
            }
        }

    }
    //Comment Area End=====================================================

    //Search Area==========================================================
    fun postSearch(search_Data: String, success: (JSONObject) -> Unit, error: (String) -> Unit) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.postSearchData(user_id, search_Data)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else
                    error(response.code().toString())
            }
        }
    }

    //Search Area End======================================================

    //Contest Area=========================================================
    fun requestContestScreen(success: (JSONObject) -> Unit, error: (String) -> Unit) {
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.requestContestScreen()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    success(JSONObject(prettyJson))
                } else {
                    error(response.code().toString())
                }
            }
        }
    }
    //Contest Area End====================================================

    //Postdetail Area=====================================================

    fun requestPostdetail(post_id: Int, success: (JSONObject) -> Unit, error: (String) -> Unit) {
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.requestPostDetail(post_id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    Log.d("retrofitclient : ", "requestPostdetail: $prettyJson")
                    success(JSONObject(prettyJson))
                } else {
                    error(response.code().toString())
                }
            }
        }

    }

    //Postdetail Area End=================================================

    //Write Area==========================================================

    fun postWriteData(
        title: String,
        content: String,
        languageType: Int,
        success: (JSONObject) -> Unit,
        error: (String) -> Unit
    ) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val testTag = "#TestTag #Class"
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.postWriteData(user_id, title, content, testTag, languageType)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    Log.d("requestBookmark", "$prettyJson ")
                    success(JSONObject(prettyJson))
                } else
                    error(response.code().toString())
            }
        }
    }

    //Write Area End======================================================


    //Bookmark Area=======================================================
    fun requestBookmark(success: (JSONObject) -> Unit, error: (String) -> Unit) {
        val user_id = Firebase.auth.currentUser?.uid.toString()
        val service = buildRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.requestBookmark(user_id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(response.body()?.string())
                    )
                    Log.d("requestBookmark", "$prettyJson ")
                    success(JSONObject(prettyJson))
                } else
                    error(response.code().toString())
            }
        }
    }


    //Register Area=========================================================
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

