package com.example.graduation_project.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_postdetail.*

class PostdetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postdetail)
        supportActionBar?.hide()

        post_txt_content.setText(intent.getStringExtra("content"))
        post_detail_txt_tag.setText(intent.getStringExtra("tag"))
        //post_language_img.setImageResource(intent.getIntExtra("language_img"))


        post_img_banner_finish.setOnClickListener {
            finish()
        }

        img_btn_comment.setOnClickListener {
            post_detail_post_layout.isInvisible = true
            post_detail_comment_layout.isVisible = true
        }

        post_comment_img_back.setOnClickListener {
            post_detail_post_layout.isVisible = true
            post_detail_comment_layout.isInvisible = true
        }
    }
}