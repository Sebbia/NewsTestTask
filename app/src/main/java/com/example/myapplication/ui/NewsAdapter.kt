package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.News

class NewsAdapter : PagedListAdapter<News, NewsAdapter.NewsViewHolder>(NEWS_COMPARATOR){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_card,parent,false)

        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        news?.let{
            holder.bind(news)
        }
    }




    class NewsViewHolder(view : View):RecyclerView.ViewHolder(view){
         private val title = view.findViewById<TextView>(R.id.titleID)

        fun bind (news : News){
            title.text = news.title
        }
    }

    companion object{
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<News>(){
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.id ==  newItem.id

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                newItem == oldItem



        }
    }


}