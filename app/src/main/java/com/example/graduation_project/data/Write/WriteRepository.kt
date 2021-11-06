package com.example.graduation_project.data.Write

class WriteRepository(val dataSource: WriteDataSource) {

    fun postWriteData(title:String,content :String,languageType:Int,result:(Result<Unit>)->Unit){
        return dataSource.postWriteData(title,content,languageType){

        }
    }

}