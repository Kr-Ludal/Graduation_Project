package com.example.graduation_project.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.PostdetailActivity
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_home.view.*

class HomeAdapter(val homeListItem: ArrayList<HomeModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    val homefragment = HomeFragment()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_home, parent, false)

        return ViewHolder(v).apply {
            itemView.home_cardview_bookmark.setOnClickListener {
                val getpos: Int = adapterPosition
                if (homefragment.homeListItem.get(getpos).bookmark_checkable == 1) {
                    itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_uncheck_border_24)
                    homefragment.homeListItem.get(getpos).bookmark_checkable == 0
                } else {
                    itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_check_24)
                    homefragment.homeListItem.get(getpos).bookmark_checkable == 1
                }
            }
            itemView.setOnClickListener {

                val curPos: Int = adapterPosition
                val intent = Intent(parent.context, PostdetailActivity::class.java)
                intent.putExtra(
                    "language_img",
                    this@HomeAdapter.homeListItem.get(curPos).language_img
                )
                intent.putExtra("tag", this@HomeAdapter.homeListItem.get(curPos).tag)
                intent.putExtra(
                    "info",
                    this@HomeAdapter.homeListItem.get(curPos).date + " : " + this@HomeAdapter.homeListItem.get(
                        curPos
                    ).saved + " Saved"
                )
                intent.putExtra("content", "        # Here we get the actual classes")
                parent.context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return homeListItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(homeListItem[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: HomeModel) {
            itemView.home_cardview_profile_img.setImageResource(model.profile_img)
            itemView.home_cardview_nametxt.text = model.nickname
            itemView.home_cardview_title_txt.text = model.title
            itemView.home_cardview_tag_txt.text = model.tag
            itemView.home_cardview_status_txt.text =
                model.date + " : " + model.saved.toString() + " Saved"
            itemView.home_cardview_language_image.setImageResource(model.language_img)
            if (model.bookmark_checkable.equals(1)) {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_check_24)
            } else {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_uncheck_border_24)
            }

        }
    }

}