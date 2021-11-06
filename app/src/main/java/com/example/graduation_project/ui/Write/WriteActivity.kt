package com.example.graduation_project.ui.Write

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.home_listview.*

class WriteActivity : AppCompatActivity() {

    private lateinit var writeViewModel : WriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val languageType = intent.getIntExtra("languageType",0)

        supportActionBar?.hide()

        writeViewModel = ViewModelProvider(this,WriteViewModelFactory())
            .get(WriteViewModel::class.java)

        writeViewModel.writeFromState.observe(this, Observer {
            val writeState =it ?:return@Observer
            floatingActionButton.isEnabled = writeState.isBothDataValid
            if(!writeState.isBothDataValid){
                //Toast.makeText(this, R.string.Write_Contents_Error, Toast.LENGTH_SHORT).show()
            }
        })

        Write_Title_text.apply {
            afterTextChanged {
                writeViewModel.writeDataChanged(
                    Write_Title_text.toString(),
                    code_editor.toString()
                )
            }
        }


        val hashTagArray : Array<out String>? = Write_Hashtag_Text.insertTag

        activity_write_back_button.setOnClickListener {
            finish()
        }

        floatingActionButton.setOnClickListener {
            writeViewModel.postWriteData(Write_Title_text.toString(),code_editor.toString(),languageType)
        }

        initCodeEditor()
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }


    private fun initCodeEditor() {
        // erase lineNumber
        code_editor.isLineNumberEnabled = false
    }
}