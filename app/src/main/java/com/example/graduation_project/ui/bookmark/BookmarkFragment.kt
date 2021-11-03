package com.example.graduation_project.ui.bookmark

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.fragment_bookmark.*

class BookmarkFragment : Fragment() {

    private lateinit var bookmarkViewModel: BookmarkViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bookmarkViewModel=ViewModelProvider(this,BookmarkViewModelFactory())
            .get(BookmarkViewModel::class.java)

        bookmarkViewModel.getBookmarkItem()

        bookmarkViewModel.bookmarkDataState.observe(viewLifecycleOwner, Observer {
            val bookmarkState = it ?: return@Observer

            bookmark_Recycler.layoutManager= LinearLayoutManager(requireContext())
            bookmark_Recycler.adapter = BookmarkAdapter(bookmarkState)
            bookmark_Recycler.setHasFixedSize(true)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }
}