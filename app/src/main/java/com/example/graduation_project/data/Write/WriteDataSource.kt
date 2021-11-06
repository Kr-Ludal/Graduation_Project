package com.example.graduation_project.data.Write

import com.example.graduation_project.RetrofitClient

class WriteDataSource {

    fun postWriteData(title:String, content:String,languageType:Int,result: (Result<Unit>)->Unit){

        RetrofitClient.getInstance().postWriteData(title,content,languageType,{

        }){

        }

    }

}