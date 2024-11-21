package com.example.myapplication

import com.example.myapplication.ui.screens.home.HomeScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel

    @Before
    fun setUp() {
        viewModel = HomeScreenViewModel()
    }

    @Test
    fun recentWateredPlants() = runTest {
        val expectedPlants = listOf("Plante 1", "Plante 2", "Plante 3", "Plante 4")
        assertEquals(expectedPlants, viewModel.recentWateredPlants)
    }

    @Test
    fun temperature() = runTest {
        assertEquals("12 °C", viewModel.temperature)
    }

    @Test
    fun weatherCondition() = runTest {
        assertEquals("Regnbyger", viewModel.weatherCondition)
    }

    @Test
    fun precipitatio() = runTest {
        assertEquals("90%", viewModel.precipitation)
    }

    @Test
    fun plantDangerMessage() = runTest {
        assertEquals("Innkommende flom!", viewModel.plantDangerMessage)
    }
}
