package com.example.graduation_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_postdetail.*

class PostdetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postdetail)
        supportActionBar?.hide()

        post_txt_content.setText(intent.getStringExtra("content"))
        postdetail_txt_tag.setText(intent.getStringExtra("tag"))
        //post_language_img.setImageResource(intent.getIntExtra("language_img"))

        post_img_benner_finisih.setOnClickListener{
            finish()
        }

        img_btn_comment.setOnClickListener {
            postdetail_post_layout.isInvisible=true
            postdetail_comment_layout.isVisible=true
        }

        post_comment_img_back.setOnClickListener{
            postdetail_post_layout.isVisible=true
            postdetail_comment_layout.isInvisible=true
        }
    }
}