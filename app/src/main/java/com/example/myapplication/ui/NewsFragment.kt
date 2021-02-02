package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.adapters.NewsAdapter
import com.example.myapplication.ui.utils.clickListener
import com.example.myapplication.viewmodel.NewsFactory
import com.example.myapplication.viewmodel.NewsViewModel

import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(), clickListener {
    //private val viewModel: NewsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }




    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val newsAdapter = NewsAdapter(this)
        val appCtx = requireActivity().application

        newsRecyclerViewID.layoutManager = LinearLayoutManager(activity)

        val id = arguments?.getInt("id")

        val newsItemViewModel = ViewModelProvider(this, NewsFactory(appCtx, id))
        .get(NewsViewModel::class.java)

        newsItemViewModel.newsPagedList.observe(viewLifecycleOwner, Observer {

            newsAdapter.submitList(it)
        })
        newsRecyclerViewID.adapter = newsAdapter
        }

    override fun onNewsClickListener(id: Int, shortDesc:String,title:String) {
        println(id.toString())
        val bundle = Bundle()
        bundle.putString("short", shortDesc)
        bundle.putString("title", title)
        bundle.putInt("id", id)
        (activity as MainActivity).navController.navigate(
            R.id.action_newsFragment_to_detFragment,
            bundle
        )
    }





}