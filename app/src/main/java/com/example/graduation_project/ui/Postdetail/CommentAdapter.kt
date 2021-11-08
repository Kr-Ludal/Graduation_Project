package com.example.graduation_project.ui.Postdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_comment.view.*

class CommentAdapter(val commentListItem: ArrayList<CommentModel>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_comment,parent,false)

        return ViewHolder(v).apply {
            itemView.cardview_comment_img_favorite.setOnClickListener {
                val curPos : Int = adapterPosition
                if(this@CommentAdapter.commentListItem[curPos].likeCheckable==1){
                    itemView.cardview_comment_img_favorite.setColorFilter(R.color.res_cardview_comment_unlike_color)
                }else{
                    itemView.cardview_comment_img_favorite.setColorFilter(R.color.res_cardview_comment_like_color)
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


        }
    }
}