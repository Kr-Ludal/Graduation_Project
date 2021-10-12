package com.example.graduation_project.data.Login

import com.example.graduation_project.data.Login.model.LoggedInUser
import com.example.graduation_project.ui.login.LoggedInUserView


class LoginRepository(val dataSource: LoginDataSource) {

    fun login(userid: String, password: String, result: (Result<LoggedInUserView>) -> Unit) {
        dataSource.loginEmail(userid, password, result)
    }

}