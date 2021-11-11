package com.example.graduation_project.ui.Write

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.textclassifier.TextClassifierEvent
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import io.github.rosemoe.sora.langs.python.PythonLanguage
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.home_listview.*
import kotlinx.coroutines.newFixedThreadPoolContext
import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.langs.java.JavaLanguage
import io.github.rosemoe.sora.langs.universal.LanguageDescription
import kotlin.jvm.internal.Intrinsics

class WriteActivity : AppCompatActivity() {

    private lateinit var writeViewModel: WriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val languageType = intent.getIntExtra("languageType", 0)

        supportActionBar?.hide()

        writeViewModel = ViewModelProvider(this, WriteViewModelFactory())
            .get(WriteViewModel::class.java)

        when (languageType) {
            1 -> {code_editor.setEditorLanguage(PythonLanguage()) }
            6 -> { code_editor.setEditorLanguage(JavaLanguage()) }
        }


        writeViewModel.writeFromState.observe(this, Observer {
            val writeState = it ?: return@Observer
            floatingActionButton.isEnabled = writeState.isTitleDataValid
        })

        Write_Title_text.apply {
            afterTextChanged {
                writeViewModel.writeDataChanged(
                    Write_Title_text.text.toString()
                )
            }
        }

        activity_write_back_button.setOnClickListener {
            finish()
        }

        floatingActionButton.setOnClickListener {
            if (Write_Title_text.text.toString().equals("") || code_editor.text.toString()
                    .equals("")
            ) {
                Toast.makeText(this, "제목 혹은 내용을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                writeViewModel.postWriteData(
                    Write_Title_text.text.toString(),
                    code_editor.text.toString(),
                    languageType
                )
                finish()
            }
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