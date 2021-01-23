package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.model.Categories
import com.example.myapplication.model.CategoriesResponse
import com.example.myapplication.service.NewsApiService
import com.example.myapplication.service.NewsApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCat()
    }

    private fun getCat() {
        val catService = NewsApiServiceBuilder.getService(NewsApiService::class.java)
        val call = catService.getCategories()
        call.enqueue(object : Callback<CategoriesResponse>{
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Log.d( "onResponse: ", t.toString())
            }

            override fun onResponse(
                call: Call<CategoriesResponse>,
                response: Response<CategoriesResponse>
            ) {
                val apiResponse = response.body()!!
                val responseItems = apiResponse.list
                Log.d( "onResponse: ", responseItems[0].toString())
            }

        })

    }
}