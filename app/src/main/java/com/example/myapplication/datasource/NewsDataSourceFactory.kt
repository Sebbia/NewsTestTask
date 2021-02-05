package com.example.myapplication.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.myapplication.data.model.News

class NewsDataSourceFactory(idCat: Int) : DataSource.Factory<Int, News>(){
    val idCat = idCat
    val newsLiveDataSource = MutableLiveData<NewsDataSource>()
    override fun create(): DataSource<Int, News> {
        val idCat = idCat
        val newsDataSource = NewsDataSource(idCat)

        newsLiveDataSource.postValue(newsDataSource)

        return newsDataSource

    }
}