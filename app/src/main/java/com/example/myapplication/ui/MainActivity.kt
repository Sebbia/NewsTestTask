package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsAdapter = NewsAdapter()

        newsRecyclerViewID.layoutManager = LinearLayoutManager(this)

        val newsItemViewModel = ViewModelProviders.of(this)
            .get(NewsViewModel::class.java)

        newsItemViewModel.newsPagedList.observe(this, Observer {
            newsAdapter.submitList(it)
        })

        newsRecyclerViewID.adapter = newsAdapter
    }

}