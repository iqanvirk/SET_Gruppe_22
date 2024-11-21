package com.example.myapplication

import com.example.myapplication.ui.screens.home.HomeScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalTime


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

    @Test
    fun test_getTimeOfDay_morning() = runTest {
        val fakeMorningTime = LocalTime.of(6, 0)
        val actualTimeOfDay = viewModel.getTimeOfDay(fakeMorningTime)
        assertEquals("God morgen!", actualTimeOfDay)
    }

    @Test
    fun test_getTimeOfDay_midday() = runTest {
        val fakeMiddayTime = LocalTime.of(9, 0)
        val actualTimeOfDay = viewModel.getTimeOfDay(fakeMiddayTime)
        assertEquals("God formiddag!", actualTimeOfDay)
    }

    @Test
    fun test_getTimeOfDay_afternoon() = runTest {
        val fakeAfternoonTime = LocalTime.of(12, 0)
        val actualTimeOfDay = viewModel.getTimeOfDay(fakeAfternoonTime)
        assertEquals("God ettermiddag!", actualTimeOfDay)
    }

    @Test
    fun test_getTimeOfDay_evening() = runTest {
        val fakeEveningTime = LocalTime.of(18, 0)
        val actualTimeOfDay = viewModel.getTimeOfDay(fakeEveningTime)
        assertEquals("God kveld!", actualTimeOfDay)
    }

    @Test
    fun test_getTimeOfDay_night() = runTest {
        val fakeNightTime = LocalTime.of(0, 0)
        val actualTimeOfDay = viewModel.getTimeOfDay(fakeNightTime)
        assertEquals("God natt!", actualTimeOfDay)
    }

    @Test
    fun test_GetTimeIcon_morning_exact() {
        val morningBoundary = LocalTime.of(6, 0)
        val result = viewModel.getTimeIcon(morningBoundary)
        assertEquals(R.drawable.sunrise, result)
    }

    @Test
    fun test_GetTimeIcon_morning() {
        val morningTime = LocalTime.of(8, 0)
        val result = viewModel.getTimeIcon(morningTime)
        assertEquals(R.drawable.sunrise, result)
    }

    @Test
    fun test_GetTimeIcon_evening_exact() {
        val eveningBoundary = LocalTime.of(18, 0)
        val result = viewModel.getTimeIcon(eveningBoundary)
        assertEquals(R.drawable.moon, result)
    }

    @Test
    fun test_GetTimeIcon_evening() {
        val eveningTime = LocalTime.of(20, 0)
        val result = viewModel.getTimeIcon(eveningTime)
        assertEquals(R.drawable.moon, result)
    }
}
