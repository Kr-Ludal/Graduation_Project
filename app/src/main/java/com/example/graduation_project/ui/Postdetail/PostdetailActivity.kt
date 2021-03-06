package com.example.graduation_project.ui.Postdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
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

        val getPostId = intent.getIntExtra("post_id", 0)
        val getLanguageImg = intent.getIntExtra("language_img", 0)
        val getTag = intent.getStringExtra("tag")
        val getNickname = intent.getStringExtra("nickname")
        val getTitle = intent.getStringExtra("title")
        val getDate = intent.getStringExtra("date")
        val getProfile_img = intent.getIntExtra("profile_img", 0)

        Comment_Recycler.layoutManager = LinearLayoutManager(this)
        Comment_Recycler.setHasFixedSize(true)

        postdetailViewModel = ViewModelProvider(this, PostdetailViewModelFactory())
            .get(PostdetailViewModel::class.java)

        postdetailViewModel.getPostdetailData(getPostId)

        postdetailViewModel.postdetailDataState.observe(this, Observer {
            val postdetailState = it ?: return@Observer

            post_txt_content.text = postdetailState
            post_language_img.setImageResource(setLanguageImage(getLanguageImg))
            post_detail_txt_tag.text = getTag
            post_detail_txt_info.text = getDate
            post_banner_nickname.text = getNickname
            post_banner_title.text = getTitle
            post_banner_profile_img.setImageResource(getProfile_img)

            post_comment_nickname.text = getNickname
            post_comment_profile.setImageResource(getProfile_img)
            post_comment_title.text = getTitle
        })

        postdetailViewModel.commentDataState.observe(this, Observer {
            val commentState = it ?: return@Observer

            Comment_Recycler.layoutManager = LinearLayoutManager(this)
            Comment_Recycler.adapter = CommentAdapter(commentState)
        })

        postdetailViewModel.commentFormState.observe(this, Observer {
            val commentFormState = it ?: return@Observer
            post_detail_btn_post.isEnabled=commentFormState

        })

        post_detail_btn_post.setOnClickListener {
            val comment = post_detail_write_txt.text.toString()
            Log.d("postDetailActivity", "postComment : $comment $getPostId")
            postdetailViewModel.postCommentData(post_detail_write_txt.text.toString(), getPostId)
            post_detail_write_txt.setText("")
            postdetailViewModel.getCommentData(getPostId)
        }

        post_detail_write_txt.setOnFocusChangeListener { v,
        hasFocus ->
            if (hasFocus) {
                post_detail_btn_post.isVisible = true
            } else {
                post_detail_btn_post.isInvisible = true
            }
        }

        post_img_banner_finish.setOnClickListener {
            finish()
        }

        img_btn_comment.setOnClickListener {
            post_detail_post_layout.isInvisible = true
            post_detail_comment_layout.isVisible = true
            postdetailViewModel.getCommentData(getPostId)
        }

        post_comment_img_back.setOnClickListener {
            post_detail_post_layout.isVisible = true
            post_detail_comment_layout.isInvisible = true
        }

        post_detail_write_txt.apply {
            afterTextChanged {
                postdetailViewModel.loginDataChanged(post_detail_write_txt.text.toString())
            }
        }

    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

    }
    private fun setLanguageImage(languageType : Int) : Int{
        var type = 0
        when(languageType){
            1->{type=R.drawable.ic_python}
            2->{type=R.drawable.ic_cplpl}
            3->{type=R.drawable.ic_c}
            4->{type=R.drawable.ic_cshop}
            5->{type=R.drawable.ic_kotlin}
            6->{type=R.drawable.ic_java}
            7->{type=R.drawable.ic_swift}
            8->{type=R.drawable.ic_javascript}

        }
        return type
    }
}
