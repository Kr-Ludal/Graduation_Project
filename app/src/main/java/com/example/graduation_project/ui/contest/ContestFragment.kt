package com.example.graduation_project.ui.contest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.fragment_contest.*

class ContestFragment : Fragment() {

    var profileList = mutableListOf<ContestModel>()

    private lateinit var contestViewModel: ContestViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        contestViewModel = ViewModelProvider(
            requireActivity(),
            ContestViewModelFectory()
        ).get(ContestViewModel::class.java)





        profileList.add(
            ContestModel(
                "class MetricsCallback(Callback):\n" +
                        "    def __init__(self, test_data, y_true):\n" +
                        "        # Should be the label encoding of your classes\n" +
                        "        self.y_true = y_true\n" +
                        "        self.test_data = test_data\n" +
                        "\n" +
                        "    def on_epoch_end(self, epoch, logs=None):\n" +
                        "        # Here we get the probabilities - longer process\n" +
                        "        y_pred = self.model.predict(self.test_data)\n" +
                        "\n" +
                        "        # Here we get the actual classes",
                R.drawable.ic_javascript,
                "올리비아",
                R.drawable.ic_python,
                1
            )
        )


        Contest_Recycler.layoutManager = LinearLayoutManager(requireContext())
        Contest_Recycler.adapter = ContestAdapter(profileList)

        Contest_Recycler.setHasFixedSize(true)

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