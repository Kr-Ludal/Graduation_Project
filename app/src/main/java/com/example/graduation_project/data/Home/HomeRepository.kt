package com.example.graduation_project.data.Home

import com.example.graduation_project.ui.home.HomeModel

class HomeRepository(val dataSource: HomeDataSource) {

    fun getBoardData(result: (Result<ArrayList<HomeModel>>) -> Unit) {
        dataSource.getHomeBoardData(result)
    }
}