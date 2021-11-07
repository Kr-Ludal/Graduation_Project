package com.example.graduation_project.ui.contest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_contest.view.*
import kotlinx.android.synthetic.main.cardview_home.view.*
import kotlin.collections.ArrayList


class ContestAdapter(val profileList: ArrayList<ContestModel>) :
    RecyclerView.Adapter<ContestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_contest, parent, false)

        return ViewHolder(v).apply {
            itemView.setOnClickListener {

            }
        }

    }


    override fun getItemCount(): Int {
        return profileList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(profileList[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: ContestModel) {

            itemView.contest_cardview_text.text = model.text
            itemView.contest_cardview_profile_img.setImageResource(model.profile_img)
            itemView.contest_cardview_name.text = model.nickname
            itemView.contest_cardview_language_img.setImageResource(model.language_img)
            itemView.contest_cardview_medal_img.isVisible=model.medal
        }
    }
}