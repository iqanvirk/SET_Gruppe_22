package com.example.myapplication.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class HomeScreenViewModel : ViewModel() {
    // State for recent watered plants
    private val _recentWateredPlants = mutableStateListOf("Plant 1", "Plant 2", "Plant 3", "Plant 4")
    val recentWateredPlants: SnapshotStateList<String> get() = _recentWateredPlants

    // State for weather information
    val temperature: String = "12 °C"
    val weatherCondition: String = "Regnbyger"
    val precipitation: String = "90%"

    // State for plant danger
    val plantDangerMessage: String = "Innkommende flom!"
}
