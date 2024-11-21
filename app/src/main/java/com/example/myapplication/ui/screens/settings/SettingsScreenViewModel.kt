package com.example.myapplication.ui.screens.settings

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingsScreenViewModel : ViewModel() {
    var isDarkMode = mutableStateOf(false)
    var selectedLanguage = mutableStateOf("Norsk")
    var searchText = mutableStateOf("")

    init {
        isDarkMode.value = false
        selectedLanguage.value = "Norsk"
    }

    fun darkMode1() {
        isDarkMode.value = !isDarkMode.value
    }

    fun updateSearchText(newText: String) {
        searchText.value = newText
    }

    fun logout(context: Context) {
    }
}

