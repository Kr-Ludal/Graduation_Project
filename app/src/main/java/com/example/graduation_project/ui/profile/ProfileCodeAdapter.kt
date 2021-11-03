package com.example.graduation_project.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import com.example.graduation_project.ui.home.HomeModel
import kotlinx.android.synthetic.main.cardview_home.view.*

class ProfileCodeAdapter(val profileCodeItem: ArrayList<HomeModel>): RecyclerView.Adapter<ProfileCodeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_home,parent,false)

        return ViewHolder(v).apply{}
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(profileCodeItem[position])
    }

    override fun getItemCount(): Int {
        return profileCodeItem.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: HomeModel) {
            itemView.home_cardview_profile_img.setImageResource(model.profile_img)
            itemView.home_cardview_nametxt.text = model.nickname
            itemView.home_cardview_title_txt.text = model.title
            itemView.home_cardview_tag_txt.text = model.tag
            itemView.home_cardview_status_txt.text =
                model.date.split("T")[0] + " : " + model.saved.toString() + " Saved"
            itemView.home_cardview_language_image.setImageResource(model.language_img)
            if (model.bookmark_checkable.equals(1)) {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_check_24)
            } else {
                itemView.home_cardview_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_uncheck_border_24)
            }

        }
    }
}