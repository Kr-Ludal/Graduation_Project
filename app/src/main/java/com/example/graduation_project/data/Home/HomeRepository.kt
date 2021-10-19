package com.example.graduation_project.data.Home

import com.example.graduation_project.ui.home.HomeModel

class HomeRepository(val dataSource : HomeDataSource) {

    fun getBoardData() : ArrayList<HomeModel> {
        val result = dataSource.getHomeBoardData()

        return result
    }


}