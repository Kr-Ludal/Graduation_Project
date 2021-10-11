package com.example.graduation_project.ui.Register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.R
import com.example.graduation_project.data.Register.RegisterRepository

class RegisterViewModel (private val registerRepository: RegisterRepository) : ViewModel(){

    private val _registerFrom=MutableLiveData<RegisterFormState>()
    val registerFormState : LiveData<RegisterFormState> = _registerFrom

    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult : LiveData<RegisterResult> = _registerResult

    fun register(useremail : String, password : String, username : String){
        val result = registerRepository.register(useremail,password,username)

        if(result == true){
            _registerResult.value = RegisterResult(success = true)
        }else{_registerResult.value = RegisterResult(error=R.string.Register_error)
        }

    }
    fun registerDataChanged(userEmail: String , password: String, userName : String){

        if(!isEmailDataValid(userEmail)){
            _registerFrom.value = RegisterFormState(registeremailError =  R.string.Register_userEmail_error)
        }else if(!isPasswordValid(password)){
            _registerFrom.value = RegisterFormState(registerpasswordError = R.string.Register_Password_error)
        }else if(!isUserNameValid(userName)){
            _registerFrom.value = RegisterFormState(registernameError = R.string.Register_userName_error)
        }

        if(isEmailDataValid(userEmail)){
            _registerFrom.value = RegisterFormState(isEmailDataValid = true)
        }else if(isPasswordValid(password)){
            _registerFrom.value = RegisterFormState(isPasswordDataValid = true)
        }else if(isUserNameValid(userName)){
            _registerFrom.value = RegisterFormState(isNameDataValid = true)
        }

    }



    private fun isEmailDataValid(username: String):Boolean{
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }
    private fun isPasswordValid(password: String):Boolean{
        return password.length > 5
    }
    private fun isUserNameValid(userName : String):Boolean{
        return userName.isNotBlank()
    }
}