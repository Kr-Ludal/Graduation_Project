package com.example.graduation_project.ui.post

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        supportActionBar?.hide()

        activity_write_back_button.setOnClickListener {
            finish()
        }

        initCodeEditor()
    }
    
    private fun initCodeEditor() {
        // erase lineNumber
        code_editor.isLineNumberEnabled = false
    }
}