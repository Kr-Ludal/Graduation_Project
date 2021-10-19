package com.example.graduation_project.data.Home

import android.accounts.NetworkErrorException
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.home.HomeModel

class HomeDataSource {

    private var mainDataSource = ArrayList<HomeModel>()

    fun getHomeBoardData(result: (Result<ArrayList<HomeModel>>) -> Unit) {
        RetrofitClient.getInstance().requestMainScreen({
            mainDataSource = (mainDataSource + it.getJSONArray("feeds")) as ArrayList<HomeModel>
            result(Result.Success(mainDataSource))
        }, {
            result(Result.Error(NetworkErrorException()))
        })

    }
}