package com.example.myapplication.viewmodel



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.Categories
import com.example.myapplication.repository.NewsRepository


class CatViewModel(application: Application) : AndroidViewModel(application) {

    val reposytory = NewsRepository()
    val categoryLivedata : MutableLiveData<List<Categories>>

    init{
        categoryLivedata = reposytory.getCategory()

    }
}