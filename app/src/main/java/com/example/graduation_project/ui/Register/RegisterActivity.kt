package com.example.graduation_project.ui.Register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        var emailSave: String = ""
        var passwordSave: String = ""
        var nameSave : String = ""

        proBar.progress = 1
        proBar.max = 3


        registerViewModel=ViewModelProvider(this,RegisterViewModelFectory()).get(RegisterViewModel::class.java)

        registerViewModel.registerFormState.observe(this@RegisterActivity, Observer {
            val registerState = it ?: return@Observer

            if (proBar.progress.equals(1)) {
                btnNext.isEnabled = registerState.isEmailDataValid
            } else if (proBar.progress.equals(2)) {
                btnNext.isEnabled = registerState.isPasswordDataValid
            } else if (proBar.progress.equals(3)) {
                btnNext.isEnabled = registerState.isNameDataValid
            }

            if (registerState.registeremailError != null) {
                regiEmail.error = getString(registerState.registeremailError)
            }
            if (registerState.registerpasswordError != null) {
                regiPw.error = getString(registerState.registerpasswordError)
            }
            if (registerState.registernameError != null) {
                regiName.error = getString(registerState.registernameError)
            }
        })

        registerViewModel.registerResult.observe(this@RegisterActivity, Observer {
            val registerResult = it ?: return@Observer
            if(registerResult.error !=null){
                Toast.makeText(applicationContext,"회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
            if(registerResult.success !=null){
                Toast.makeText(applicationContext,"회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }

        })

        register_btn_back.setOnClickListener{
            proBar.incrementProgressBy(-1)
            if(proBar.progress.equals(0))
                finish()
            else if(proBar.progress.equals(1)){
                linear_pw.isInvisible=true
                linear_email.isVisible=true
                regiEmail.setText("$emailSave")
            }
            else if(proBar.progress.equals(2)) {
                linear_pw.isVisible=true
                linear_name.isInvisible=true
                regiPw.setText("$passwordSave")
            }

        }

        btnNext.setOnClickListener {
            if(proBar.progress.equals(1)){
                    linear_pw.isVisible=true
                    linear_email.isInvisible=true
                    proBar.incrementProgressBy(1)
                    page_count.setText(proBar.progress.toString()+" of 3")
                    emailSave=regiEmail.text.toString()
                    regiEmail.setText(null)
            }else if(proBar.progress.equals(2)){
                    linear_pw.isInvisible=true
                    linear_name.isVisible=true
                    proBar.incrementProgressBy(1)
                    page_count.setText(proBar.progress.toString()+" of 3")
                    passwordSave= regiPw.text.toString()
                    regiPw.setText(null)
            }else if(proBar.progress.equals(3)) {
                    linear_name.isInvisible=true
                    linear_sign_up.isInvisible=true
                    linear_congratulation.isVisible=true
                    relative_next.isInvisible=true
                    relative_finish.isVisible=true
                    linear_txt_congratulation.isVisible=true
                    nameSave = regiName.text.toString()
                    regiName.setText(null)
            }
        }

        regiEmail.apply {
            afterTextChanged{
            registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
            }
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
                }
                false
            }

        }

        regiPw.apply { afterTextChanged {
            registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
            }
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
                }
                false
            }
        }

        regiName.apply { afterTextChanged {
            registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
            }
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        registerViewModel.registerDataChanged(regiEmail.text.toString(),regiPw.text.toString(),regiName.text.toString())
                }
                false
            }
        }

        btnfinish.setOnClickListener {
            registerViewModel.register(emailSave,passwordSave,nameSave)
            finish()
        }

        edtxt_register_password_visivility.setOnClickListener {
            if(regiPw.transformationMethod.equals(HideReturnsTransformationMethod.getInstance())){
                regiPw.transformationMethod = PasswordTransformationMethod.getInstance()
                edtxt_register_password_visivility.setImageResource(R.drawable.ic_launcher_eye_foreground)
            }else{
                regiPw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                edtxt_register_password_visivility.setImageResource(R.drawable.ic_launcher_eye_off_foreground)
            }
        }


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

}