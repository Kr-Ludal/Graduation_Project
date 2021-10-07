package com.example.graduation_project.data.Login

import com.example.graduation_project.data.Login.model.LoggedInUser


class LoginRepository (val dataSource: LoginDataSource){

    var user: LoggedInUser?=null //
        private set

    val isLoggedIn : Boolean
        get() = user != null

    init{
        user=null
    }
    fun logout(){
        user=null
        dataSource.logout()
    }




    fun login(userid : String, password : String): Result<LoggedInUser>{

        val result = dataSource.login(userid,password)

        if(result is Result.Success){
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser){
        this.user = loggedInUser
    }

}