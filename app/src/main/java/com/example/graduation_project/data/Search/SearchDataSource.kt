package com.example.graduation_project.data.Search

import android.accounts.NetworkErrorException
import android.util.Log
import com.example.graduation_project.R
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.home.HomeModel
import org.json.JSONObject

class SearchDataSource {

    private var mainDataSource = ArrayList<HomeModel>()

    fun getSearchData(inputData:String ,result: (Result<ArrayList<HomeModel>>) -> Unit) {
        RetrofitClient.getInstance().postSearch(inputData,{
            val jsonArray = it.getJSONArray("search")
            val arrayList = mutableListOf<HomeModel>()
            for (i in 0 until jsonArray.length()) {
                val item = jsonArray.get(i) as JSONObject
                //val uid = item.get("uid")
                val title = item.get("title")
                val post_tag = item.get("post_tag")
                val language_type = item.get("language_type") as Int
//                val language_thumbnails = item.get("language_thumbnails")
                val post_id = item.get("post_id") as Int
                val write_time = item.get("write_time")
                val writer_nickname = "choi"//item.get("writer_nickname")
//                val writer_thumbnail = item.get("writer_thumbnail")
//                val line_of_code = item.get("line_of_code")
//                val bookmark_saved = item.get("bookmark_saved")
                var bookmark : Int = item.get("bookmark") as Int
                Log.d("searchDataSorce", "bookmark no.$i ,bookmark : $bookmark post id : $post_id ")

                arrayList.add(HomeModel(
                    R.drawable.ic_javascript,
                    title.toString(), writer_nickname.toString(),
                    post_tag.toString(), write_time.toString(),
                    0, language_type, bookmark,post_id))
            }

                //mainDataSource = ((mainDataSource + arrayList) as ArrayList<HomeModel>)
            result(Result.Success(mainDataSource))
        }, {
            Log.d("TAG", "getSearchData: fail")
            result(Result.Error(NetworkErrorException()))
        })

    }
}