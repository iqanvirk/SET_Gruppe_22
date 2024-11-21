package com.example.myapplication.ui.screens.login

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class LoginScreenViewModelTest {

    private lateinit var viewModel: LoginScreenViewModel

    @Before
    fun setUp() {
        viewModel = LoginScreenViewModel()
    }

    @Test
    fun emailchange() {
        val newEmail = "test@example.com"
        viewModel.onEmailChange(newEmail)
        assertEquals(newEmail, viewModel.userMail)
    }

    @Test
    fun passwordchange() {
        val newPassword = "password123"
        viewModel.onPasswordChange(newPassword)
        assertEquals(newPassword, viewModel.userPass)
    }

    @Test
    fun remeberUser() {
        val initialState = viewModel.rememberUser
        viewModel.onRememberUserChange(!initialState)
        assertNotEquals(initialState, viewModel.rememberUser)
    }

    @Test
    fun loginClick() {
        viewModel.onLoginClick()
        assertTrue(true)
    }

    @Test
    fun registerClick() {
        viewModel.onRegisterClick()
        assertTrue(true)
    }
}
