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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import com.example.graduation_project.ui.contest.ContestModel
import com.example.graduation_project.ui.home.HomeModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    var solutionArray = ArrayList<ContestModel>()
    var codeArray = ArrayList<HomeModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        codeArray.add(HomeModel(R.drawable.nexon,
            "나이가 가장 많은 사람은 누구일까? 테이블을 뒤져 통계를 내어봅시다."
            ,"넥슨갈끄니까"
            ,"#algorithm #syntax"
            ,"2021-10-18.13:06:50:30"
            ,0
            ,R.drawable.ic_kotlin
            ,0
            ,60
        ))

        solutionArray.add(ContestModel("class MetricsCallback(Callback):\n" +
                "    def __init__(self, test_data, y_true):\n" +
                "        # Should be the label encoding of your classes\n" +
                "        self.y_true = y_true\n" +
                "        self.test_data = test_data\n" +
                "\n" +
                "    def on_epoch_end(self, epoch, logs=None):\n" +
                "        # Here we get the probabilities - longer process\n" +
                "        y_pred = self.model.predict(self.test_data)\n" +
                "\n" +
                "        # Here we get the actual classes",R.drawable.nexon,"넥슨갈끄니까",R.drawable.ic_swift,false))
        solutionArray.add(ContestModel("class MetricsCallback(Callback):\n" +
                "    def __init__(self, test_data, y_true):\n" +
                "        # Should be the label encoding of your classes\n" +
                "        self.y_true = y_true\n" +
                "        self.test_data = test_data\n" +
                "\n" +
                "    def on_epoch_end(self, epoch, logs=None):\n" +
                "        # Here we get the probabilities - longer process\n" +
                "        y_pred = self.model.predict(self.test_data)\n" +
                "\n" +
                "        # Here we get the actual classes",R.drawable.nexon,"넥슨갈끄니까",R.drawable.ic_swift,false))
        Profile_Recycler.layoutManager = LinearLayoutManager(requireContext())
        Profile_Recycler.adapter = ProfileCodeAdapter(codeArray)
        Profile_Recycler.setHasFixedSize(true)

        profileViewModel = ViewModelProvider(this, ProfileViewModelFactory())
                .get(ProfileViewModel::class.java)

        profileViewModel.profileCodeDataState.observe(viewLifecycleOwner, Observer {
            val codeDataState = it?:return@Observer



        })

        profileViewModel.profileSolutionDataState.observe(viewLifecycleOwner, Observer {
            val solutionDataState = it ?: return@Observer

            Profile_Recycler.layoutManager = LinearLayoutManager(requireContext())
            Profile_Recycler.adapter = ProfileSolutionAdapter(solutionDataState)
            Profile_Recycler.setHasFixedSize(true)
        })

        profile_Radiogroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio_codes) {
                radio_codes.setTypeface(Typeface.DEFAULT_BOLD)
                radio_codes.setTextColor(Color.parseColor("#ffffff"))

                Profile_Recycler.adapter = ProfileCodeAdapter(codeArray)

            } else {
                radio_codes.setTypeface(Typeface.DEFAULT)
                radio_codes.setTextColor(Color.parseColor("#111111"))
            }

            if (checkedId == R.id.radio_solutions) {
                radio_solutions.setTypeface(Typeface.DEFAULT_BOLD)
                radio_solutions.setTextColor(Color.parseColor("#ffffff"))

                Profile_Recycler.adapter = ProfileSolutionAdapter(solutionArray)

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