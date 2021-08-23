package com.example.graduation_project.Login

import com.example.graduation_project.ui.login.LoggedInUserView

class LoginRepository (val dataSource: LoginDataSource){

    fun login(userid : String,password : String):Result<LoggedInUserView>


}