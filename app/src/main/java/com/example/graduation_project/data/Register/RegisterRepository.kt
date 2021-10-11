package com.example.graduation_project.data.Register

import com.example.graduation_project.ui.Register.RegisterResult

class RegisterRepository(val dataSource: RegisterDataSource) {


    fun register(userEmail : String, password : String, userName : String) : Boolean {

        val result = dataSource.register(userEmail,password,userName)

        return result

    }
}