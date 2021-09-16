package com.example.graduation_project.ui.contest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_home.view.*
import java.util.*
import kotlin.collections.ArrayList

//
class ContestAdapter(val arrayList: ArrayList<ContestModel>,val context:Context): RecyclerView.Adapter<ContestAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bindItems(model:ContestModel) {

            itemView.profile_img.setImageResource(model.profile_img)
            itemView.nametxt.text=model.nickname
            itemView.title_txt.text=model.title
            itemView.tag_txt.text=model.tag
            itemView.status_txt.text = model.date + model.saved


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.cardview_home,parent,false)
        return ViewHolder(v)

        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return arrayList.size
        TODO("Not yet implemented")
    }


}