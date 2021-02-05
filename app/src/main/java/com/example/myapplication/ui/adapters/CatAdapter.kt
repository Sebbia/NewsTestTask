package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Categories
import com.example.myapplication.ui.utils.clickListenerCat


class CatAdapter(private val values: List<Categories>,private val cellClickListener: clickListenerCat) : RecyclerView.Adapter<CatAdapter.CatVewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatVewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_card,parent,false)

        return CatVewHolder(view)
    }

    override fun onBindViewHolder(holder: CatVewHolder, position: Int) {
        val cat = values[position]
        cat?.let{
            holder.bind(cat)
        }

        holder.itemView.setOnClickListener {
            cellClickListener.onNewsClickListener(cat.id)
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }

    class CatVewHolder(view : View):RecyclerView.ViewHolder(view){

        private val title = view.findViewById<TextView>(R.id.catTitleID)
        fun bind (cats : Categories){
            title.text = cats.name
        }
    }



}