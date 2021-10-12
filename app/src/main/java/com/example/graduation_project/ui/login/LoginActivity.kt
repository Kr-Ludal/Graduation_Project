package com.example.graduation_project.ui.login

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType.*
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import com.example.graduation_project.StartActivity

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this, LoginViewModelFectory())
                .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it
                    ?: return@Observer//loginformstate에 값을 받음 null값일 때 return하고 아니면 그 값 넣기


            btnEnter.isEnabled = loginState.isDataValid//isDataVaild가 참거짓에 따라 변경

            if (loginState.useridError != null) {//loginformstate에 있는 useriderror에 값이 null이 아니라면
                edtxtId.error = getString(loginState.useridError)
            }
            if (loginState.passwordError != null) {
                edtxtPw.error = getString(loginState.passwordError)
            }
        })


        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer//로그인 성공 실패 여부를 판별하는 부분.

            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)//로그인에 실패하였습니다 뜸.
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)//Welcome! 누구누구 나옴
                Log.d("로그인", "로그인 성공!")
            }
            setResult(Activity.RESULT_OK)

            finish()//그리고 끔
        })



        edtxtId.afterTextChanged {
            loginViewModel.loginDataChanged(//logindatachanged에 값을 넣었을 때 null값인지, 이메일인지의 여부 판별
                    edtxtId.text.toString(),
                    edtxtPw.text.toString()
            )
        }

        edtxtPw.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        edtxtId.text.toString(),
                        edtxtPw.text.toString()
                )
            }
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                edtxtId.text.toString(),
                                edtxtPw.text.toString()
                        )
                }
                false
            }
            btnEnter.setOnClickListener {
                //val i = Intent(this@LoginActivity, HomeActivity::class.java)
                //startActivityForResult(i, RESULT_OK)

                loginViewModel.login(edtxtId.text.toString(), edtxtPw.text.toString())
            }
        }

        backLogin.setOnClickListener {
            finish()
        }

        passwordVisibility.setOnClickListener {
            if (edtxtPw.transformationMethod.equals(HideReturnsTransformationMethod.getInstance())) {
                edtxtPw.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordVisibility.setImageResource(R.drawable.ic_round_visibility_24)
            } else {
                edtxtPw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                passwordVisibility.setImageResource(R.drawable.ic_round_visibility_off_24)
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val Welcome = R.string.Login_Welcome
        val displayId = model.displayId
        Toast.makeText(applicationContext, "$Welcome $displayId", Toast.LENGTH_SHORT).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

    }
}

/*btnEnter.setOnClickListener {
        RetrofitClient.getInstance().getUserInfo(edtxtId.toString(), edtxtPw.toString(),
            {

            },
            { it, t ->
                Log.d("Login Faild", "Login Faild")
                Toast.makeText(this, "아이디 혹은 비밀번호를 확인해주시기 바랍니다.", Toast.LENGTH_SHORT).show()
            })

    }*/
