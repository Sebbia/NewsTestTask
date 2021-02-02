package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.adapters.CatAdapter
import com.example.myapplication.ui.utils.clickListenerCat
import com.example.myapplication.viewmodel.CatViewModel

import kotlinx.android.synthetic.main.fragment_cat.*


class CatFragment : Fragment(R.layout.fragment_cat), clickListenerCat {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val catItemViewModel = ViewModelProvider(this)
            .get(CatViewModel::class.java)

        catRecyclerViewID.layoutManager = LinearLayoutManager(activity)

        catItemViewModel.categoryLivedata.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            catRecyclerViewID.adapter = CatAdapter(it,this)
        })

    }


    override fun onNewsClickListener(id:Int) {
        (activity as MainActivity).navController.navigate(R.id.action_catFragment_to_newsFragment,
            bundleOf("id" to id))
    }



}