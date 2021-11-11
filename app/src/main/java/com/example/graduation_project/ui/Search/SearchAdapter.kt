package com.example.graduation_project.ui.Search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.cardview_popular_recent.view.*

class SearchAdapter(val searchListItem:ArrayList<String>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_popular_recent,parent,false)
        return ViewHolder(v).apply {
            itemView.setOnClickListener {
                val cursor = adapterPosition

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(searchListItem[position])
    }

    override fun getItemCount(): Int {
        return searchListItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: String) {
            itemView.Search_Pop_Rec_Text.text = model
        }
    }
}