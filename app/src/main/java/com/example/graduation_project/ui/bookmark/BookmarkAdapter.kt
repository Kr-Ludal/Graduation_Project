package com.example.graduation_project.ui.bookmark

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.Postdetail.PostdetailActivity
import com.example.graduation_project.ui.home.HomeModel
import kotlinx.android.synthetic.main.cardview_home.view.*

class BookmarkAdapter(val bookmarkListItem : ArrayList<HomeModel>):
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_home, parent, false)

        return ViewHolder(v).apply {
            itemView.home_cardview_bookmark.setOnClickListener {
                val getpos: Int = adapterPosition
                val post_id: Int = this@BookmarkAdapter.bookmarkListItem.get(getpos).post_Id
                if (this@BookmarkAdapter.bookmarkListItem.get(getpos).bookmark_checkable == 1) {
                    itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_uncheck_border_24)
                    RetrofitClient.getInstance().removeMainScreenBookmark(post_id, {
                    }, {
                        Log.d("home bookmark fail", "fail")
                    })
                    this@BookmarkAdapter.bookmarkListItem.get(getpos).bookmark_checkable = 0
                } else {
                    itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_check_24)
                    RetrofitClient.getInstance().addMainScreenBookmark(post_id, {

                    }, {
                        Log.d("home bookmark fail", "fail")
                    })
                    this@BookmarkAdapter.bookmarkListItem.get(getpos).bookmark_checkable = 1
                }
            }
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val post_Id = this@BookmarkAdapter.bookmarkListItem[curPos].post_Id

                val intent = Intent(parent.context, PostdetailActivity::class.java)
                intent.putExtra("post_id", post_Id)
                intent.putExtra("language_img",this@BookmarkAdapter.bookmarkListItem[curPos].language_img)
                intent.putExtra("date",itemView.home_cardview_status_txt.text)
                intent.putExtra("nickname",this@BookmarkAdapter.bookmarkListItem[curPos].nickname)
                intent.putExtra("title",this@BookmarkAdapter.bookmarkListItem[curPos].title)
                intent.putExtra("tag",this@BookmarkAdapter.bookmarkListItem[curPos].tag)
                intent.putExtra("profile_img",this@BookmarkAdapter.bookmarkListItem[curPos].profile_img)
                parent.context.startActivity(intent)

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(bookmarkListItem[position])
    }

    override fun getItemCount(): Int {
        return bookmarkListItem.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: HomeModel) {
            itemView.home_cardview_profile_img.setImageResource(model.profile_img)
            itemView.home_cardview_nametxt.text = model.nickname
            itemView.home_cardview_title_txt.text = model.title
            itemView.home_cardview_tag_txt.text = model.tag
            itemView.home_cardview_status_txt.text =
                model.date.split("T")[0] + "." + model.date.split("T",".")[1] + " : " + model.saved.toString() + " Saved"
            itemView.home_cardview_language_image.setImageResource(model.language_img)
            if (model.bookmark_checkable.equals(1)) {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_check_24)
            } else {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_uncheck_border_24)
            }

        }
    }
}