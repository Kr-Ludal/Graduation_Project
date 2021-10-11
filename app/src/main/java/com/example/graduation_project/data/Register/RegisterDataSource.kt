package com.example.graduation_project.data.Register

import com.example.graduation_project.RetrofitClient


class RegisterDataSource {

    fun register(userEmail: String, password: String, userName: String) : Boolean {
        var result : Boolean = false
        RetrofitClient.getInstance().postUserInfo(userEmail,password,userName,
        {
            result = true
        },{
            it,t->
            result = false
        })


        return result
    }

}