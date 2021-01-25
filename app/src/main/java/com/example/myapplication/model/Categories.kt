package com.example.myapplication.model

data class Categories(
        private var id: Int,
        private var name: String
)

data class CategoriesResponse(
    val code: Int,
    val list: List<Categories>
)

