package com.example.myapplication.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.myapplication.model.News

class NewsDataSourceFactory : DataSource.Factory<Int, News>(){

    val newsLiveDataSource = MutableLiveData<NewsDataSource>()
    override fun create(): DataSource<Int, News> {

        val newsDataSource = NewsDataSource()
        newsLiveDataSource.postValue(newsDataSource)

        return newsDataSource

    }
}