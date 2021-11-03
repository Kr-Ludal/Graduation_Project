package com.example.graduation_project.ui.profile

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        profileViewModel = ViewModelProvider(this, ProfileViewModelFactory())
                .get(ProfileViewModel::class.java)

        profileViewModel.profileCodeDataState.observe(viewLifecycleOwner, Observer {
            val codeDataState = it?:return@Observer



        })

        profileViewModel.profileSolutionDataState.observe(viewLifecycleOwner, Observer {
            val solutionDataState = it ?: return@Observer

        })


        profile_Radiogroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio_codes) {
                radio_codes.setTypeface(Typeface.DEFAULT_BOLD)
                radio_codes.setTextColor(Color.parseColor("#ffffff"))
            } else {
                radio_codes.setTypeface(Typeface.DEFAULT)
                radio_codes.setTextColor(Color.parseColor("#111111"))
            }

            if (checkedId == R.id.radio_solutions) {
                radio_solutions.setTypeface(Typeface.DEFAULT_BOLD)
                radio_solutions.setTextColor(Color.parseColor("#ffffff"))
            } else {
                radio_solutions.setTypeface(Typeface.DEFAULT)
                radio_solutions.setTextColor(Color.parseColor("#111111"))
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}