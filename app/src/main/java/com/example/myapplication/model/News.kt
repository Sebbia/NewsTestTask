package com.example.myapplication.model
data class News(
        var date: String,
        var id: Int,
        var shortDescription: String,
        var title: String
)

data class NewsResponse(
    val code: Int,
    val list: List<News>
)

