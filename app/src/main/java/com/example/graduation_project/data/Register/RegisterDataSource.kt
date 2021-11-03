package com.example.graduation_project.data.Register

import android.accounts.NetworkErrorException
import com.example.graduation_project.RetrofitClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase


class RegisterDataSource {

    var successCnt = 0

    fun register(
        userEmail: String,
        password: String,
        userName: String,
        result: (Result<Unit>) -> Unit
    ) {

        val auth = Firebase.auth
        auth.createUserWithEmailAndPassword(userEmail, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    successCnt = 0

                    // Firebase Update User Profile
                    val user = Firebase.auth.currentUser
                    val profileUpdates = userProfileChangeRequest {
                        displayName = userName
                    }
                    user!!.updateProfile(profileUpdates)
                        .addOnCompleteListener { updateTask ->
                            if (updateTask.isSuccessful) {
                                requestCombainRegister(result)
                            } else {
                                result(updateTask.exception?.let { Result.Error(it) }!!)
                            }
                        }

                    // Server Register Request
                    RetrofitClient.getInstance().requestSignUp(user.uid,
                        {
                            requestCombainRegister(result)
                        },
                        {
                            result(Result.Error(NetworkErrorException()))
                        })
                } else {
                    result(task.exception?.let { Result.Error(it) }!!)
                }
            }
            .addOnFailureListener {
                result(Result.Error(it))
            }
    }

    private fun requestCombainRegister(result: (Result<Unit>) -> Unit) {
        if (++successCnt >= 2) {
            result(Result.Success(Unit))
        }
    }
}

