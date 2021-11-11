package com.example.graduation_project.ui.Postdetail

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import com.example.graduation_project.RetrofitClient
import kotlinx.android.synthetic.main.cardview_comment.view.*

class CommentAdapter(val commentListItem: ArrayList<CommentModel>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_comment, parent, false)

        return ViewHolder(v).apply {
            itemView.cardview_comment_img_favorite.setOnClickListener {
                val curPos: Int = adapterPosition
                val comment_uid: Int = this@CommentAdapter.commentListItem[curPos].comment_uid
                val user_id =this@CommentAdapter.commentListItem[curPos].name
                Log.d("commentadapter", "$comment_uid")
                if (this@CommentAdapter.commentListItem[curPos].likeCheckable == 0) {
                    RetrofitClient.getInstance().postCommentLike(comment_uid, {
                        itemView.cardview_comment_img_favorite
                            .setColorFilter(Color.RED)
                        val likePlus = this@CommentAdapter.commentListItem[curPos].like+1
                        this@CommentAdapter.commentListItem[curPos].like=likePlus
                        itemView.cardview_comment_favorite_count.text=likePlus.toString()
                        this@CommentAdapter.commentListItem[curPos].likeCheckable=1
                        Log.d("commentAdapter", "comment_like: success")
                    }, {
                        Log.d("commentAdapter", "comment_like: fail")
                    })
                } else {
                    RetrofitClient.getInstance().cancelCommentLike(comment_uid, {
                        itemView.cardview_comment_img_favorite
                            .setColorFilter(Color.GRAY)
                        val removeLike=this@CommentAdapter.commentListItem[curPos].like-1
                    this@CommentAdapter.commentListItem[curPos].like=removeLike
                        itemView.cardview_comment_favorite_count.text= removeLike.toString()
                        this@CommentAdapter.commentListItem[curPos].likeCheckable=0
                        Log.d("commentAdapter", "comment_unlike: success")
                    }, {
                        Log.d("commentAdapter", "comment_unlike: fail")
                    })
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(commentListItem[position])
    }

    override fun getItemCount(): Int {
        return commentListItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: CommentModel) {
            itemView.cardview_comment_profile.setImageResource(R.drawable.seolhyeon)
            itemView.cardview_comment_nickname.text = model.name
            itemView.cardview_comment_postdate.text = model.date.split("T")[0]
            itemView.cardview_comment_content.text=model.comment
            if (model.likeCheckable == 1) {
                itemView.cardview_comment_img_favorite.setColorFilter(Color.RED)
            } else {
                itemView.cardview_comment_img_favorite.setColorFilter(Color.GRAY)
            }
            itemView.cardview_comment_favorite_count.text=model.like.toString()


        }
    }

}