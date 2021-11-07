package com.example.graduation_project.ui.contest

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
import kotlinx.android.synthetic.main.fragment_contest.*

class ContestFragment : Fragment() {

    var profileList = ArrayList<ContestModel>()

    private lateinit var contestViewModel: ContestViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        profileList.add(ContestModel("class MetricsCallback(Callback):\n" +
                "    def __init__(self, test_data, y_true):\n" +
                "        # Should be the label encoding of your classes\n" +
                "        self.y_true = y_true\n" +
                "        self.test_data = test_data\n"
            ,R.drawable.zongseok,"Benne",R.drawable.ic_javascript,true))
         profileList.add(ContestModel("class MetricsCallback(Callback):\n" +
                 "    def __init__(self, test_data, y_true):\n" +
                 "        # Should be the label encoding of your classes\n" +
                 "        self.y_true = y_true\n" +
                 "        self.test_data = test_data\n" +
                 "\n" +
                 "    def on_epoch_end(self, epoch, logs=None):\n" +
                 "        # Here we get the probabilities - longer process\n" +
                 "        y_pred = self.model.predict(self.test_data)\n" +
                 "\n" +
                 "        # Here we get the actual classes",R.drawable.iu,"눈나나죽어",R.drawable.ic_swift,false))
        profileList.add(ContestModel(
                "    def on_epoch_end(self, epoch, logs=None):\n" +
                "        # Here we get the probabilities - longer process\n" +
                "        y_pred = self.model.predict(self.test_data)\n"
                ,R.drawable.seolhyeon,"올리비아",R.drawable.ic_kotlin,false))
        profileList.add(ContestModel(
            "contestViewModel.contestDataState.observe(viewLifecycleOwner, Observer {\n" +
                    "            val contestState=it ?:return@Observer\n" +
                    "\n" +
                    "            Contest_Recycler.layoutManager = LinearLayoutManager(requireContext())\n" +
                    "            Contest_Recycler.adapter = ContestAdapter(contestState)\n" +
                    "            Contest_Recycler.setHasFixedSize(true)\n" +
                    "        })"
            ,R.drawable.seahyeong,"그란데",R.drawable.ic_cplpl,false))
        profileList.add(ContestModel("class MetricsCallback(Callback):\n" +
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

        Contest_Recycler.layoutManager = LinearLayoutManager(requireContext())
        Contest_Recycler.adapter = ContestAdapter(profileList)
        Contest_Recycler.setHasFixedSize(true)

        contestViewModel = ViewModelProvider(this, ContestViewModelFectory())
            .get(ContestViewModel::class.java)

        contestViewModel.contestDataState.observe(viewLifecycleOwner, Observer {
            val contestState=it ?:return@Observer


        })


        contest_refresh_layout.setOnRefreshListener {
            contestViewModel.getContestItem()

            contest_refresh_layout.isRefreshing=false
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
        var contestView = inflater.inflate(R.layout.fragment_contest, container, false)
        return contestView

    }
}
