package com.example.graduation_project.ui.login

data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)