package com.example.graduation_project.ui.post

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.fragment_write.*


class WriteFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var checkeditem: Int = 0

        write_item_group.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId == R.id.radio_python) {
                radio_python.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_python_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_python.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 1
            } else {
                radio_python.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_python,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_python.setTypeface(Typeface.DEFAULT)
            }

            if (checkedId == R.id.radio_cplpl) {
                radio_cplpl.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_cplpl_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_cplpl.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 2
            } else {
                radio_cplpl.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_cplpl,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_cplpl.setTypeface(Typeface.DEFAULT)
            }

            if (checkedId == R.id.radio_c) {
                radio_c.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_c_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_c.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 3
            } else {
                radio_c.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_c,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_c.setTypeface(Typeface.DEFAULT)
            }

            if (checkedId == R.id.radio_cshop) {
                radio_cshop.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_cshop_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_cshop.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 4
            } else {
                radio_cshop.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_cshop,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_cshop.setTypeface(Typeface.DEFAULT)
            }

            if (checkedId == R.id.radio_kotlin) {
                radio_kotlin.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_kotlin_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_kotlin.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 5
            } else {
                radio_kotlin.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_kotlin,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_kotlin.setTypeface(Typeface.DEFAULT)
            }

            if (checkedId == R.id.radio_java) {
                radio_java.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_java_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_java.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 6
            } else {
                radio_java.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_java,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_java.setTypeface(Typeface.DEFAULT)
            }
            if (checkedId == R.id.radio_swift) {
                radio_swift.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_swift_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_swift.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 7
            } else {
                radio_swift.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_swift,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_swift.setTypeface(Typeface.DEFAULT)
            }
            if (checkedId == R.id.radio_javascript) {
                radio_javascript.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_javascript_copy,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_javascript.setTypeface(Typeface.DEFAULT_BOLD)
                checkeditem = 8
            } else {
                radio_javascript.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_javascript,
                    0,
                    R.drawable.ic_launcher_checked_foreground,
                    0
                )
                radio_javascript.setTypeface(Typeface.DEFAULT)
            }


        }

        write_enter.setOnClickListener {
            if (checkeditem == 0) {

            } else {
                write_select_language_layout.isInvisible = true
                write_post_layout.isVisible = true
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
        return inflater.inflate(R.layout.fragment_write, container, false)
    }
}