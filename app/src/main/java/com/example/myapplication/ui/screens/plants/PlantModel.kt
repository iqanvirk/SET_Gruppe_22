package com.example.myapplication.ui.screens.plants

import java.util.Date

class PlantModel(private var name: String, private var sort: String, private var plantDate: Date) {

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getSort(): String {
        return sort
    }

    fun setSort(sort: String) {
        this.sort = sort
    }

    fun getPlantDate(): Date {
        return plantDate
    }

    fun setPlantDate(plantDate: Date) {
        this.plantDate = plantDate
    }

}