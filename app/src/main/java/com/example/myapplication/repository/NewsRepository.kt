package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.Categories
import com.example.myapplication.data.model.CategoriesResponse
import com.example.myapplication.data.model.Detail
import com.example.myapplication.data.model.DetailResponse
import com.example.myapplication.service.NewsApiService
import com.example.myapplication.service.NewsApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsRepository {
    fun getCategory(): MutableLiveData<List<Categories>>{
        val service = NewsApiServiceBuilder.getService(NewsApiService :: class.java)
        val call = service.getCategories()
        val catLiveData = MutableLiveData<List<Categories>>()

        call.enqueue(object : Callback<CategoriesResponse> {
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.list
                    catLiveData.postValue(responseItem)
                }
            }
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Log.d( "onFailure: ", t.toString())
            }

        })
        return catLiveData
    }

    fun getDetail(idNews:Int): MutableLiveData<Detail>{
        val service = NewsApiServiceBuilder.getService(NewsApiService :: class.java)
        val call = service.getDetail(idNews)
        val detLiveData = MutableLiveData<Detail>()
        call.enqueue(object : Callback<DetailResponse> {
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                if(response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.news
                    detLiveData.postValue(responseItem)
                }
            }
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                Log.d( "onFailure: ", t.toString())
            }
        })
        return detLiveData
    }


}




