package com.example.graduation_project.data.Bookmark

import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.home.HomeModel

class BookmarkDataSource {

    fun getBookmarkData(result: (Result<ArrayList<HomeModel>>)->Unit){
        RetrofitClient.getInstance().requestBookmark({
            val jsonArray =it.getJSONArray("")
        },{

        })

    }
}