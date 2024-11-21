package com.example.myapplication.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import java.time.LocalTime


class HomeScreenViewModel : ViewModel() {
    private val _recentWateredPlants = mutableStateListOf("Plante 1", "Plante 2", "Plante 3", "Plante 4")
    val recentWateredPlants: SnapshotStateList<String> get() = _recentWateredPlants

    val temperature: String = "12 °C"
    val weatherCondition: String = "Regnbyger"
    val precipitation: String = "90%"

    val plantDangerMessage: String = "Innkommende flom!"

    @SuppressLint("NewApi")
    fun getTimeOfDay(currentTime: LocalTime): String {
        val morning = LocalTime.of(6, 0)
        val midday = LocalTime.of(9, 0)
        val afternoon = LocalTime.of(12, 0)
        val evening = LocalTime.of(18, 0)
        val night = LocalTime.of(23, 0)

        return if (currentTime.isAfter(morning) && currentTime.isBefore(midday)) {
            "God morgen!"
        } else if (currentTime.isAfter(midday) && currentTime.isBefore(afternoon)) {
            "God formiddag!"
        } else if (currentTime.isAfter(afternoon) && currentTime.isBefore(evening)) {
            "God ettermiddag!"
        } else if (currentTime.isAfter(evening) && currentTime.isBefore(night)) {
            "God kveld!"
        } else {
            "God natt!"
        }
    }
}
