package com.example.myapplication.service

import com.example.myapplication.data.model.CategoriesResponse
import com.example.myapplication.data.model.DetailResponse
import com.example.myapplication.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {
    @GET("/v1/news/categories")
    fun getCategories():Call<CategoriesResponse>
    @GET("/v1/news/categories/{id}/news")
    fun getNews(@Path("id") idCat:Int, @Query("page") page: Int):Call<NewsResponse>
    @GET("/v1/news/details")
    fun getDetail(@Query("id") idNews: Int):Call<DetailResponse>
}