package com.example.graduation_project.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.R
import com.example.graduation_project.data.Login.LoginRepository
import com.example.graduation_project.data.Login.Result

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>() // 라이브데이터를 수정할 수 있게 만들어줌
    val loginFormState: LiveData<LoginFormState> = _loginForm  // 수정가능한 라이브데이터를 loginFormState에 넣음

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(userid: String, password: String) {
        // 레포지토리에 있는 로그인에 요청 보냄
        loginRepository.login(userid, password) {
            // 만약 loginReposity가 보낸 로그인 요청이 성공하여 반환되었을 때 Result클래스에 success와 같다면
            if (it is Result.Success) {
                _loginResult.value =
                    LoginResult(success = it.data)
            } else {
                _loginResult.value = LoginResult(error = R.string.Login_Failed)
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(useridError = R.string.Login_userid_error)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.Login_password_error)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // userid에 @가 있으면 이메일 패턴 매치시키기. 아니면 비어있지 않다고 해줌
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}