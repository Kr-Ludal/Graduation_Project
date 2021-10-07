package com.example.graduation_project.data.Login

import android.util.Log
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.data.Login.model.LoggedInUser
import java.io.IOException

class LoginDataSource {

    fun initUserInfo(result: ()->Unit){

    }

    fun login(userid : String, password : String):Result<LoggedInUser>{

        try{
//
//            RetrofitClient.getInstance().getUserInfo(userid, //password,
//                    {
//                        val getid = it.getJSONObject("id").toString()
//                        val getpw = it.getJSONObject("password").toString()
//                        Log.d("LoginInfo", "id : ${getid}, pw${getpw}")
//                        Result.Success(LoggedInUser(getid,getpw))
//
//                    },
//                    { it, t ->
//                        Log.d("Login Faild", "Login Faild")
//                        Result.Error(IOException("Error"))
//                    })

                RetrofitClient.getInstance().getuser(userid,password,{

                },{
                    it,t->
                })


            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(),"lasodjaso")
            return Result.Success(fakeUser)
        }catch (e:Throwable){
            Log.d("LoginDataSource", "실패")
            return Result.Error(IOException("Error Logging in",e))
        }

    }




    fun logout(){

    }

}