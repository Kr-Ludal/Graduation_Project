package com.example.graduation_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backLogin.setOnClickListener{
            finish()
        /*btnEnter.setOnClickListener {
            RetrofitClient.getInstance().getUserInfo(edtxtId.toString(), edtxtPw.toString(),
                {

                },
                { it, t ->
                    Log.d("Login Faild", "Login Faild")
                    Toast.makeText(this, "아이디 혹은 비밀번호를 확인해주시기 바랍니다.", Toast.LENGTH_SHORT).show()
                })

        }*/
        }
    }
}