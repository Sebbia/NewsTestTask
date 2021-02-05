package com.example.myapplication.viewmodel

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.Detail
import com.example.myapplication.repository.NewsRepository

class DetailViewModel(application: Application, idNews:Int) : AndroidViewModel(application) {
    val id = idNews
    val reposytory = NewsRepository()


    fun onRefresh(): MutableLiveData<Detail>{
        return reposytory.getDetail(id)}

    val detailLivedata : MutableLiveData<Detail> = onRefresh()

    }



