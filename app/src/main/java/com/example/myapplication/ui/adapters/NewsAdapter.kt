package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.News
import com.example.myapplication.ui.utils.clickListener

class NewsAdapter(private val cellClickListener: clickListener) : PagedListAdapter<News, NewsAdapter.NewsViewHolder>(
    NEWS_COMPARATOR
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_card,parent,false)

        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        news?.let{
            holder.bind(news)
        }
        holder.itemView.setOnClickListener {
            if (news != null) {
                cellClickListener.onNewsClickListener(news.id,news.shortDescription,news.title)
            }
        }
    }




    class NewsViewHolder(view : View):RecyclerView.ViewHolder(view){
         private val title = view.findViewById<TextView>(R.id.titleID)
        private val shortDesc = view.findViewById<TextView>(R.id.shortNewsID)
        private val date = view.findViewById<TextView>(R.id.dateID)
        fun bind (news : News){

            title.text = news.title
            shortDesc.text = news.shortDescription
            date.text = news.date
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