package com.example.graduation_project.ui.Postdetail

data class CommentModel(
    val name : String,
    val date : String,
    val comment : String,
    var like:Int,
    var likeCheckable : Int,
    val comment_uid : Int
)
