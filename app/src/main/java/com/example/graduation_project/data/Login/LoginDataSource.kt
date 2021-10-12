package com.example.graduation_project.data.Login

import android.util.Log
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.data.Login.model.LoggedInUser
import com.example.graduation_project.ui.login.LoggedInUserView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.io.IOException

class LoginDataSource {

    fun loginEmail(userid: String, password: String, result: (Result<LoggedInUserView>) -> Unit) {
        Firebase.auth.signInWithEmailAndPassword(userid, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val currentUser = Firebase.auth.currentUser
                    result(Result.Success(
                        LoggedInUserView(displayId = currentUser?.displayName.toString())))
                } else {
                    result(task.exception?.let { Result.Error(it) }!!)
                }
            }
    }
}