package com.example.graduation_project.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import com.example.graduation_project.SearchActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        homeViewModel = ViewModelProvider(this, HomeViewModelFectory())
            .get(HomeViewModel::class.java)

        homeViewModel.getBoardItem()

        homeViewModel.homeDataState.observe(viewLifecycleOwner, Observer {
            val homeState = it ?: return@Observer

            Home_Recycler.layoutManager = LinearLayoutManager(requireContext())
            Home_Recycler.adapter = HomeAdapter(homeState)
            Home_Recycler.setHasFixedSize(true)
        })

        home_refresh_layout.setOnRefreshListener {
            homeViewModel.getBoardItem()

            home_refresh_layout.isRefreshing = false
        }

        home_txtbtn_search.setOnClickListener {
            activity?.let {
                val intent = Intent(it, SearchActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}