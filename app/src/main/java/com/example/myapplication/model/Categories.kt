package com.example.myapplication.data.model



data class Categories(

         val id: Int,
         val name: String
)

data class CategoriesResponse(
    val code: Int,
    val list: List<Categories>
)

