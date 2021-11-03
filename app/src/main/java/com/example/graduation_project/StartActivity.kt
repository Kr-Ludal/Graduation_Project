package com.example.graduation_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.graduation_project.ui.Register.RegisterActivity
import com.example.graduation_project.ui.login.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        supportActionBar?.hide()

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

        val currentUser = Firebase.auth.currentUser
        Log.d("StartActivity onResume", "$currentUser ")
        if (currentUser != null) {
            finish()
        }
    }
}