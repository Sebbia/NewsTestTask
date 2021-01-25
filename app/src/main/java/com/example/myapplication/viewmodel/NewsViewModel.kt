package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication.datasource.NewsDataSource
import com.example.myapplication.datasource.NewsDataSourceFactory
import com.example.myapplication.model.News

class NewsViewModel : ViewModel() {

    val newsPagedList : LiveData<PagedList<News>>

    private val liveNewsDataSource : LiveData<NewsDataSource>

    init{
        val itemDataSourceFactory = NewsDataSourceFactory()

        liveNewsDataSource = itemDataSourceFactory.newsLiveDataSource

        val config = PagedList.Config.Builder().setEnablePlaceholders(false)
            .setPageSize(NewsDataSource.PAGE_SIZE)
            .build()
        newsPagedList = LivePagedListBuilder(itemDataSourceFactory, config).build()
    }
}