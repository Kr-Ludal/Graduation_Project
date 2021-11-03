package com.example.graduation_project.data.Bookmark

import com.example.graduation_project.ui.home.HomeModel

class BookmarkRepository(val dataSource: BookmarkDataSource) {

    fun getBookmarkData(result : (Result<ArrayList<HomeModel>>)->Unit){
        dataSource.getBookmarkData(result)

    }

}