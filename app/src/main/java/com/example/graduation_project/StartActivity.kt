package com.example.graduation_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduation_project.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    // 임시 코드
    companion object {
        var isHaveLoginToken = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnsign_up.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivityForResult(i, RESULT_OK)

        }



        txtlogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivityForResult(i, RESULT_OK)
        }
    }

    override fun onResume() {
        super.onResume()

        if(isHaveLoginToken) {
            finish()
        }
    }
}