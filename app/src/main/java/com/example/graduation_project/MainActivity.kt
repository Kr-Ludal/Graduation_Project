package com.example.graduation_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnsign_up.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivityForResult(i, RESULT_OK)

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

    }

    fun login(view: View) {
        val i = Intent(this, LoginActivity::class.java)
        startActivityForResult(i, RESULT_OK)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE

                )
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

}