package com.example.graduation_project.data.Postdetail

import com.example.graduation_project.ui.Postdetail.PostdetailModel

class PostdetailRepository(val dataSource: PostdetailDataSource) {

    fun getPostdetailData(post_id : Int, result: (Result<ArrayList<PostdetailModel>>)->Unit){
        dataSource.getPostDetail(post_id,result)
    }

}