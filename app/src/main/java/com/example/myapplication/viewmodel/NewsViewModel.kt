package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication.datasource.NewsDataSource
import com.example.myapplication.datasource.NewsDataSourceFactory
import com.example.myapplication.data.model.News

class NewsViewModel(application: Application, idCat:Int) : AndroidViewModel(application) {

    val newsPagedList : LiveData<PagedList<News>>


    val id = idCat
    private val liveNewsDataSource : LiveData<NewsDataSource>
    init{

        val itemDataSourceFactory = NewsDataSourceFactory(idCat)

        liveNewsDataSource = itemDataSourceFactory.newsLiveDataSource

       val config = PagedList.Config.Builder().setEnablePlaceholders(true)
            .setPageSize(NewsDataSource.PAGE_SIZE)
            .build()

        newsPagedList = LivePagedListBuilder(itemDataSourceFactory, config).build()
    }

}