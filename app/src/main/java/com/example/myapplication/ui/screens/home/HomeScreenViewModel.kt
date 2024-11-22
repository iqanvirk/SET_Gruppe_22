package com.example.myapplication.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
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
        val night = LocalTime.of(23, 59, 59)

        return if (!currentTime.isBefore(morning) && currentTime.isBefore(midday)) {
            "God morgen!"
        } else if (!currentTime.isBefore(midday) && currentTime.isBefore(afternoon)) {
            "God formiddag!"
        } else if (!currentTime.isBefore(afternoon) && currentTime.isBefore(evening)) {
            "God ettermiddag!"
        } else if (!currentTime.isBefore(evening) && currentTime.isBefore(night)) {
            "God kveld!"
        } else {
            "God natt!"
        }
    }

    @SuppressLint("NewApi")
    fun getTimeIcon(currentTime: LocalTime): Int {
        val morning = LocalTime.of(6, 0)
        val evening = LocalTime.of(18, 0)

        return if (!currentTime.isBefore(morning) && currentTime.isBefore(evening)) { // Satt opp if setningen sånn her for at den skal funke nøyaktig kl 6 også
            R.drawable.sunrise
        } else {
            R.drawable.moon
        }
    }
}
