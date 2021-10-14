package com.example.graduation_project.ui.Register

data class RegisterFormState(
    val registeremailError: Int? = null,
    val registerpasswordError: Int? = null,
    val registernameError: Int? = null,
    val isEmailDataValid: Boolean = false,
    val isPasswordDataValid: Boolean = false,
    val isNameDataValid: Boolean = false
)