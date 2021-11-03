package com.example.graduation_project.ui.home

data class HomeModel(
    val profile_img: Int,
    val title: String,
    val nickname: String,
    val tag: String,
    val date: String,
    val saved: Int,
    val language_img: Int,
    var bookmark_checkable: Int,
    val post_Id: Int
)