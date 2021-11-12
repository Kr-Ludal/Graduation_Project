package com.example.graduation_project.ui.ContestPostdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_contest_comment.*

class ContestPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest_comment)

        supportActionBar?.hide()

        contest_post_detail_title_txt.text=intent.getStringExtra("title")
        contest_post_txt_content.text=intent.getStringExtra("content")
        contest_post_banner_nickname.text=intent.getStringExtra("nickname")
        contest_post_banner_profile_img
            .setImageResource(intent.getIntExtra("profile_img",0))

        contest_post_img_banner_finish.setOnClickListener {
            finish()
        }

    }
}