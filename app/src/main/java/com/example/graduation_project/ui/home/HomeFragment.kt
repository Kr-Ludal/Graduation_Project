package com.example.graduation_project.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import com.example.graduation_project.SearchActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    //var homeListItem = mutableListOf<ContestModel>()


    val homeListItem = arrayListOf(
            HomeModel(R.drawable.ic_swift, "1번글", "올리비아", "#algorithm", "2021-09-23", 1, R.drawable.ic_python, 0),
            HomeModel(R.drawable.ic_cplpl, "완주하지 못한 선수2", "올리비아", "#algorithm", "2021-09-23", 99, R.drawable.ic_python, 0),
            HomeModel(R.drawable.ic_c, "3번", "올리비아", "#algorithm", "2021-09-23", 1, R.drawable.ic_python, 0),
            HomeModel(R.drawable.ic_cshop, "4", "올리비아", "#algorithm", "2021-09-23", 1, R.drawable.ic_python, 1)


    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        /*homeListItem.add(ContestModel(R.drawable.ic_swift,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_cplpl,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_c,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_cshop,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_python,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_kotlin,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        homeListItem.add(ContestModel(R.drawable.ic_java,"완주하지 못한 선수","올리비아","#algorithm","2021-09-23",1,R.drawable.ic_python))
        */

        Home_Recycler.layoutManager = LinearLayoutManager(requireContext())
        Home_Recycler.adapter = HomeAdapter(homeListItem)
        Home_Recycler.setHasFixedSize(true)

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}