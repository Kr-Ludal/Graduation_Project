package com.example.graduation_project.data.Contest

import android.accounts.NetworkErrorException
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.contest.ContestModel
import org.json.JSONObject

class ContestDataSource {

    private var contestDataSource = ArrayList<ContestModel>()

    fun getContestBoardData(result: (Result<ArrayList<ContestModel>>) -> Unit) {

        fun getContestBoardData(result: (Result<ArrayList<ContestModel>>) -> Unit) {

            RetrofitClient.getInstance().requestContestScreen({
                val jsonArray = it.getJSONArray("feeds")
                val arrayList = mutableListOf<ContestModel>()

                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray.get(i) as JSONObject

                    //arrayList.add(ContestModel())

                }
                contestDataSource = ((contestDataSource + arrayList)) as ArrayList<ContestModel>
                result(Result.Success(contestDataSource))

            }, {
                result(Result.Error(NetworkErrorException()))
            })
        }
    }
}