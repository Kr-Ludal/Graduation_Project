package com.example.graduation_project.ui.Write

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.fragment_write.*


class WriteFragment : Fragment() {

    data class mapItem(
        val match_drawable: Int,
        val checkedItem: Int,
        val radioButton: RadioButton
    )

    lateinit var itemMap: Map<Int, mapItem>

    lateinit var itemList: List<Pair<RadioButton, Int>>

//     private lateinit var writeViewModel : WriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var checkeditem: Int = 0

        itemMap = mapOf(
            R.id.radio_python to
                    mapItem(R.drawable.ic_python_copy, 1, radio_python),
            R.id.radio_cplpl to
                    mapItem(R.drawable.ic_cplpl_copy, 2, radio_cplpl),
            R.id.radio_c to
                    mapItem(R.drawable.ic_c_copy, 3, radio_c),
            R.id.radio_cshop to
                    mapItem(R.drawable.ic_cshop_copy, 4, radio_cshop),
            R.id.radio_kotlin to
                    mapItem(R.drawable.ic_kotlin_copy, 5, radio_kotlin),
            R.id.radio_java to
                    mapItem(R.drawable.ic_java_copy, 6, radio_java),
            R.id.radio_swift to
                    mapItem(R.drawable.ic_swift_copy, 7, radio_swift),
            R.id.radio_javascript to
                    mapItem(R.drawable.ic_javascript_copy, 8, radio_javascript)
        )

        itemList = listOf(
            Pair(radio_python, R.drawable.ic_python), Pair(radio_cplpl, R.drawable.ic_cplpl),
            Pair(radio_c, R.drawable.ic_c), Pair(radio_cshop, R.drawable.ic_cshop),
            Pair(radio_kotlin, R.drawable.ic_kotlin), Pair(radio_java, R.drawable.ic_java),
            Pair(radio_swift, R.drawable.ic_swift), Pair(radio_javascript, R.drawable.ic_javascript)
        )

        write_item_group.setOnCheckedChangeListener { group, checkedId ->
            for (item in itemList) {
                item.first.setCompoundDrawablesWithIntrinsicBounds(
                    item.second,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                item.first.setTypeface(Typeface.DEFAULT)
            }

            val item = itemMap[checkedId]
            if (item != null) {
                with(item) {
                    radioButton.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        match_drawable,
                        0,
                        R.drawable.ic_launcher_checked_foreground,
                        0
                    )
                    radioButton.setTypeface(Typeface.DEFAULT_BOLD)
                }
                checkeditem = item.checkedItem
            }
        }

        write_enter.setOnClickListener {
            if (checkeditem != 0) {
                val intent = Intent(this.context, WriteActivity::class.java)

                intent.putExtra("languageType", checkeditem)
                startActivity(intent)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

}