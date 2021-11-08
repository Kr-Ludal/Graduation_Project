package com.example.graduation_project.ui.Postdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_postdetail.*

class PostdetailActivity : AppCompatActivity() {

    private lateinit var postdetailViewModel: PostdetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postdetail)
        supportActionBar?.hide()

        val getPostId = intent.getIntExtra("post_id",0)
        val getLanguageImg = intent.getIntExtra("language_img",0)
        val getTag = intent.getStringExtra("tag")
        val getNickname = intent.getStringExtra("nickname")
        val getTitle=intent.getStringExtra("title")
        val getDate=intent.getStringExtra("date")
        val getProfile_img=intent.getIntExtra("profile",0)

        Comment_Recycler.layoutManager = LinearLayoutManager(this)
        Comment_Recycler.setHasFixedSize(true)

        postdetailViewModel=ViewModelProvider(this,PostdetailViewModelFactory())
            .get(PostdetailViewModel::class.java)



        postdetailViewModel.getPostdetailData(getPostId)

        postdetailViewModel.postdetailDataState.observe(this, Observer {
            val postdetailState=it?:return@Observer

            post_txt_content.setText(postdetailState)
            post_language_img.setImageResource(getLanguageImg)
            post_detail_txt_tag.setText(getTag)
            post_detail_txt_info.setText(getDate)
            post_banner_nickname.setText(getNickname)
            post_banner_title.setText(getTitle)
            post_banner_profile_img.setImageResource(getProfile_img)

        })

        postdetailViewModel.commentDataState.observe(this, Observer {
            val commentState = it?:return@Observer
            Comment_Recycler.adapter = CommentAdapter(commentState)
        })

        post_detail_write_txt.setOnFocusChangeListener { v,
            hasFocus -> if (hasFocus){
            post_detail_btn_post.isVisible=true
            }else{
            post_detail_btn_post.isInvisible=true
            }
        }


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
