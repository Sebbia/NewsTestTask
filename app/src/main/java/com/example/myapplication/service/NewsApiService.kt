package com.example.myapplication.service

import com.example.myapplication.model.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {
    @GET("/v1/news/categories")
    fun getCategories():Call<CategoriesResponse>
}