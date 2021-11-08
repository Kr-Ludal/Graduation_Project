package com.example.graduation_project.data.Search

import com.example.graduation_project.ui.home.HomeModel

class SearchRepository(val dataSource: SearchDataSource) {

    fun getSearchData(inputData : String, result:(Result<ArrayList<HomeModel>>)->Unit){
        dataSource.getSearchData(inputData,result)
    }

}