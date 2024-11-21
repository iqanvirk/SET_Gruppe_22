package com.example.myapplication.ui.screens.plants

import androidx.lifecycle.ViewModel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.models.Plant
import com.example.myapplication.models.PlantList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date

class PlantScreenViewModel : ViewModel() {

    var plants: List<Plant>? = null
        private set

    fun loadPlants(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val plantList = loadOrCreatePlantList(context) //gson.fromJson(reader, PlantList::class.java)
            plants = plantList.plants
        }
    }

    fun addPlant(context: Context, name: String, sort: String, plantDate: Date) {
        viewModelScope.launch(Dispatchers.IO) {
            val plantList = loadOrCreatePlantList(context)

            val dateFormat = SimpleDateFormat("yyyy-MM-dd", context.resources.configuration.locales[0])
            val newPlant = Plant(name = name, sort = sort, plantDate = dateFormat.format(plantDate))

            plantList.plants.add(newPlant)

            savePlantsToJson(context, plantList)

            plants = plantList.plants
        }
    }

    private fun loadOrCreatePlantList(context: Context): PlantList {
        val file = File(context.filesDir, "plants.json")
        val gson = Gson()

        return if (file.exists()) {
            val jsonString = file.readText()
            val type = object : TypeToken<PlantList>() {}.type
            gson.fromJson(jsonString, type)
        } else {
            val inputStream = context.resources.openRawResource(R.raw.plants)
            val reader = InputStreamReader(inputStream)
            val plantList = gson.fromJson(reader, PlantList::class.java) ?: PlantList(mutableListOf())
            plantList
        }
    }

    private fun savePlantsToJson(context: Context, plantList: PlantList) {
        val gson = Gson()
        val jsonString = gson.toJson(plantList)

        val file = File(context.filesDir, "plants.json")
        file.writeText(jsonString)
    }

}