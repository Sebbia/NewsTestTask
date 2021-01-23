package com.example.myapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NewsApiServiceBuilder {
    private val BASE_URL = "https://testtask.sebbia.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T>  getService(serviceType: Class<T>): T{
        return retrofit.create(serviceType)
    }

}