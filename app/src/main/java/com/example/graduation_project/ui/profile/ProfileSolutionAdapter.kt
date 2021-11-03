package com.example.graduation_project.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import com.example.graduation_project.ui.contest.ContestModel
import kotlinx.android.synthetic.main.cardview_contest.view.*
class ProfileSolutionAdapter(val profileSolutionItem : ArrayList<ContestModel>):RecyclerView.Adapter<ProfileSolutionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_contest,parent,false)

        return ViewHolder(v).apply {

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(profileSolutionItem[position])
    }

    override fun getItemCount(): Int {
        return profileSolutionItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: ContestModel) {

            itemView.contest_cardview_text.text = model.text
            itemView.contest_cardview_profile_img.setImageResource(model.profile_img)
            itemView.contest_cardview_name.text = model.nickname
            itemView.contest_cardview_language_img.setImageResource(model.language_img)

        }
    }
}

