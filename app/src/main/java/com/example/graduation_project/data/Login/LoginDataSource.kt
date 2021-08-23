package com.example.graduation_project.data.Login

import com.example.graduation_project.data.Login.model.LoggedInUser
import java.io.IOException

class LoginDataSource {

    fun login(userid : String, password : String): Result<LoggedInUser>{
        try{
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(),"Ludal")
            return Result.Success(fakeUser)
        }catch (e:Throwable){
            return Result.Error(IOException("Error Logging in",e))
        }
    }
    fun logout(){

    }

}