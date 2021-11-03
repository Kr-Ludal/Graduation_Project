package com.example.graduation_project.ui.Postdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_postdetail.*

class PostdetailActivity : AppCompatActivity() {

    private lateinit var postdetailViewModel: PostdetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postdetail)
        supportActionBar?.hide()
        post_txt_content.setText(intent.getStringExtra("post_id"))

        postdetailViewModel=ViewModelProvider(this,PostdetailViewModelFactory())
            .get(PostdetailViewModel::class.java)

        postdetailViewModel.postdetailDataState.observe(this, Observer {
            val postdetailState=it?:return@Observer



        })

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