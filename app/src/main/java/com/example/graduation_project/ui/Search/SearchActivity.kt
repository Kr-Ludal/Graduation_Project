package com.example.graduation_project.ui.Search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import com.example.graduation_project.ui.home.HomeAdapter
//import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var searchViewModel : SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.hide()

        Search_Recycler.layoutManager = LinearLayoutManager(this)
        Search_Recycler.setHasFixedSize(true)

        searchViewModel=ViewModelProvider(this,SearchViewModelFactory())
            .get(SearchViewModel::class.java)

        searchViewModel.searchDataState.observe(this, Observer {
            val searchState = it?:return@Observer

            Search_Recycler.adapter = HomeAdapter(searchState)


        })

        edtxt_search_detail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("TAG", "afterTextChanged: $s")
                searchViewModel.getSearchItem(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.length > 0) {
                        search_result.isVisible = true
                        search_before.isInvisible = true
                    } else{
                        search_before.isVisible = true
                        search_result.isInvisible = true
                    }
                }
            }


        })
        search_back.setOnClickListener {
            finish()
        }
    }


    /*fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                onTextChanged.invoke(editable.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }
        })*/

}
