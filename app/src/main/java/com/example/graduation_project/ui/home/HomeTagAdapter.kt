package com.example.graduation_project.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_home.view.*
import kotlinx.android.synthetic.main.cardview_home_tagitem.view.*

class HomeTagAdapter(val homeTagListItem : ArrayList<String>):
    RecyclerView.Adapter<HomeTagAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_home_tagitem,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(homeTagListItem[position])
    }

    override fun getItemCount(): Int {
        return homeTagListItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: String) {
            itemView.cardview_home_tag_item_txt.setText(model)
        }
    }
}