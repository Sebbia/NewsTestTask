package com.example.myapplication.data.model

data class Detail(
        var date: String,
        var fullDescription: String,
        var id: Int,
        var shortDescription: String,
        var title: String
)

data class DetailResponse(
    val code: Int,
    val news: Detail
)

