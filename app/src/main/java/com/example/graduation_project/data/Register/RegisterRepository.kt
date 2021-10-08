package com.example.graduation_project.data.Register

class RegisterRepository(val dataSource: RegisterDataSource) {


    fun register(userEmail : String, password : String, userName : String){

        val result = dataSource.register(userEmail,password,userName)

        return result

    }
}