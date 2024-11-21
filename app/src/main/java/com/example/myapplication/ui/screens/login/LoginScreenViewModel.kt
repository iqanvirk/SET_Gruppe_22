package com.example.myapplication.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class LoginScreenViewModel : ViewModel() {

    var userMail by mutableStateOf("")
    var userPass by mutableStateOf("")
    var rememberUser by mutableStateOf(false)

    fun onEmailChange(email: String) {
        userMail = email
    }

    fun onPasswordChange(password: String) {
        userPass = password
    }

    fun onRememberUserChange(isChecked: Boolean) {
        rememberUser = isChecked
    }
    fun onLoginClick() {
    }

    fun onRegisterClick() {

    }
}

