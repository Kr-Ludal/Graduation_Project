package com.example.graduation_project.data.Home

import android.accounts.NetworkErrorException
import android.util.Log
import com.example.graduation_project.R
import com.example.graduation_project.RetrofitClient
import com.example.graduation_project.ui.home.HomeModel
import org.json.JSONObject
import kotlin.random.Random

class HomeDataSource {

    private var mainDataSource = ArrayList<HomeModel>()

    fun getHomeBoardData(result: (Result<ArrayList<HomeModel>>) -> Unit) {

        RetrofitClient.getInstance().requestMainScreen({
            val jsonArray = it.getJSONArray("feeds")
            val arrayList = mutableListOf<HomeModel>()
            for (i in 0 until jsonArray.length()) {
                val random = (1..8).random()
                val item = jsonArray.get(i) as JSONObject
                //val uid = item.get("uid")
                val title = item.get("title")
                val post_tag = item.get("post_tag")
                val language_type = item.get("language_type") as Int
//                val language_thumbnails = item.get("language_thumbnails")
                val post_id = item.get("post_id") as Int
                val write_time = item.get("write_time")
                val writer_nickname = setNickname(random)//item.get("writer_nickname")
//                val writer_thumbnail = item.get("writer_thumbnail")
//                val line_of_code = item.get("line_of_code")
//                val bookmark_saved = item.get("bookmark_saved")
                var bookmark : Int = item.get("bookmark") as Int
                Log.d("homeDataSource", "bookmark no.$i ,bookmark : $bookmark post id : $post_id ")


                arrayList.add(HomeModel(setProfileImage(random),
                    title.toString(), writer_nickname,
                    post_tag.toString(), write_time.toString(),
                    0, language_type, bookmark,post_id))
            }

            mainDataSource = ((mainDataSource + arrayList) as ArrayList<HomeModel>)
            result(Result.Success(mainDataSource))
        }, {
            Log.d("TAG", "getHomeBoardData: fail")
            result(Result.Error(NetworkErrorException()))
        })

    }
    private fun setProfileImage(languageType : Int) : Int{
        var type = 0
        when(languageType){
            1->{type=R.drawable.hongbin}
            2->{type=R.drawable.nico}
            3->{type=R.drawable.seolhyeon}
            4->{type=R.drawable.seahyeong}
            5->{type=R.drawable.gongyou}
            6->{type=R.drawable.nana}
            7->{type=R.drawable.zongseok}
            8->{type=R.drawable.iu}
        }
        return type
    }
    private fun setNickname(languageType : Int) : String{
        var nickname =""
        when(languageType){
            1->{nickname="올리비아"}
            2->{nickname="린다"}
            3->{nickname="갤러거"}
            4->{nickname="그란데"}
            5->{nickname="로드리고"}
            6->{nickname="베네"}
            7->{nickname="유라"}
            8->{nickname="에이든"}
        }
        return nickname
    }
}