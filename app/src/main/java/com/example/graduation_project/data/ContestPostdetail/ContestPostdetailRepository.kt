package com.example.graduation_project.data.ContestPostdetail

class ContestPostdetailRepository (val dataSource:ContestPostdetailDataSource){

    fun getContestData(result:(Result<String>)->Unit){
        dataSource.getContestData(result)
    }

}