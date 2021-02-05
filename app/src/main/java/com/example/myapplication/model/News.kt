package com.example.myapplication.data.model




data class News(
        val id: Int,
        val date: String,
        val shortDescription: String,
        val title: String
)

data class NewsResponse(
    val code: Int,
    val list: List<News>
)

