package com.example.graduation_project.data.Contest

import com.example.graduation_project.ui.contest.ContestModel

class ContestRepository (val dataSource : ContestDataSource){

    fun getContestData(result: (Result<ArrayList<ContestModel>>)->Unit){
        dataSource.getContestBoardData(result)

    }

}