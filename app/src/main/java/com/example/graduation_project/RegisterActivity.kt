package com.example.graduation_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        proBar.progress = 1
        proBar.max = 3

        imageButton.setOnClickListener{
            proBar.incrementProgressBy(-1)
            if(proBar.progress.equals(0))
                finish()
            else if(proBar.progress.equals(1)){
                linear_pw.isInvisible=true
                linear_email.isVisible=true
            }
            else if(proBar.progress.equals(2)) {
                linear_pw.isVisible=true
                linear_name.isInvisible=true

            }

        }

        btnNext.setOnClickListener {
            if(proBar.progress.equals(1)){
                if(regiEmail.text.toString().equals("")) {
                    Toast.makeText(this, "Please, Write your email.", Toast.LENGTH_SHORT).show()
                }
                else{
                    linear_pw.isVisible=true
                    linear_email.isInvisible=true
                    proBar.incrementProgressBy(1)
                    page_count.setText(proBar.progress.toString()+" of 3")
                }

            }else if(proBar.progress.equals(2)){
                if(regiPw.text.toString().equals("")){
                    Toast.makeText(this, "Please, Write your password.", Toast.LENGTH_SHORT).show()
                }
                else{
                    linear_pw.isInvisible=true
                    linear_name.isVisible=true
                    proBar.incrementProgressBy(1)
                    page_count.setText(proBar.progress.toString()+" of 3")
                }

            }

            else if(proBar.progress.equals(3)) {
                if(regiPw.text.toString().equals("")){
                    Toast.makeText(this, "Please, Write your name.", Toast.LENGTH_SHORT).show()
                }
                else{
                    linear_name.isInvisible=true
                    linear_sign_up.isInvisible=true
                    linear_congratulation.isVisible=true
                    linear_next.isInvisible=true
                    linear_finish.isVisible=true
                    linear_txt_congratulation.isVisible=true
                }
            }
        }

        btnfinish.setOnClickListener {
            finish()
        }


    }

}