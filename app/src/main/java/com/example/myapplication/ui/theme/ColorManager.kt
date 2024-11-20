package com.example.myapplication.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object ColorManager {
    var isDarkMode by mutableStateOf(false)

    val Background: Color
        get() = if (isDarkMode) DarkmodeBackground else LightmodeBackground
    val DarkBackground: Color
        get() = if (isDarkMode) DarkmodeBackground2 else LightmodeBackground2
    val TextColor: Color
        get() = if (isDarkMode) DarkmodeTextColor else LightmodeTextColor
}
