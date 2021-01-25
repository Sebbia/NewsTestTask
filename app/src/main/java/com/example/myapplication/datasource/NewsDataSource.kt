package com.example.myapplication.datasource

import android.app.PendingIntent.getService
import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.myapplication.model.News
import com.example.myapplication.model.NewsResponse
import com.example.myapplication.service.NewsApiService
import com.example.myapplication.service.NewsApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDataSource: PageKeyedDataSource<Int, News>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, News>
    )

    {
        val service = NewsApiServiceBuilder.getService(NewsApiService :: class.java)
        val call = service.getNews(0, INITIAL_PAGE)

        call.enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
               if(response.isSuccessful){
                   val apiResponse = response.body()!!
                   val responseItem = apiResponse.list
                   callback.onResult(responseItem,null, INITIAL_PAGE)

               }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d( "onFailure: ", t.toString())
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        val service = NewsApiServiceBuilder.getService(NewsApiService :: class.java)
        val call = service.getNews(0, params.key)

        call.enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.list
                    val key = if (params.key>1) params.key +1 else 0
                    callback.onResult(responseItem, key)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("onFailure: ", t.toString())
            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        val service = NewsApiServiceBuilder.getService(NewsApiService :: class.java)
        val call = service.getNews(0, params.key)

        call.enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    if (response.isSuccessful){
                        val apiResponse = response.body()!!
                        val responseItem = apiResponse.list
                        val key = params.key + 1
                        callback.onResult(responseItem, key)
                    }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("onFailure: ", t.toString())
            }

        })
    }

    companion object{
        const val PAGE_SIZE = 6
        const val INITIAL_PAGE = 0
    }
}