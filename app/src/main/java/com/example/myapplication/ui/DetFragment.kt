package com.example.myapplication.ui

import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.viewmodel.DetailFactory
import com.example.myapplication.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_det.*


class DetFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_det, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val id = arguments?.getInt("id")
        val title = arguments?.getString("title")
        val shortDesc = arguments?.getString("short")


        titleID.text = title
        shortDescriptionID.text = shortDesc
        val appCtx = requireActivity().application
        val detItemViewModel = ViewModelProviders.of(this, id?.let { DetailFactory(appCtx, it) })
            .get(DetailViewModel::class.java)
        detItemViewModel.detailLivedata.observe(viewLifecycleOwner, Observer {

            fullDescriptionID.text = Html.fromHtml(it.fullDescription)
            fullDescriptionID.setMovementMethod(LinkMovementMethod.getInstance())
        })


        swipeRefreshLayout.setOnRefreshListener {

                detItemViewModel.onRefresh()
                detItemViewModel.onRefresh().observe(viewLifecycleOwner, Observer {

                    fullDescriptionID.text = Html.fromHtml(it.fullDescription)
                    fullDescriptionID.setMovementMethod(LinkMovementMethod.getInstance())
                })
                swipeRefreshLayout.isRefreshing = false
            }



        }
        }


