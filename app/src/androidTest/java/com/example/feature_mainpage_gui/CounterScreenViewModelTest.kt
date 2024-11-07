package com.example.feature_mainpage_gui

import com.example.feature_mainpage_gui.ui.screens.counter.CounterScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class CounterScreenViewModelTest {

    private lateinit var viewModel: CounterScreenViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        // Properly instantiate the ViewModel with parentheses
        viewModel = CounterScreenViewModel()
    }

    @Test
    fun initiatCountIsZero() = runBlockingTest {
        assertEquals(0, viewModel.count.first())
    }

    @Test
    fun incrementIncreasesCountBy1() = runBlockingTest {
        viewModel.increment()
        assertEquals(1, viewModel.count.first())
    }

    @Test
    fun decrement() = runBlockingTest {
        viewModel.increment()
        viewModel.increment()
        viewModel.decrement()
        assertEquals(1, viewModel.count.first())
    }

    @Test
    fun zero() = runBlockingTest {
        viewModel.decrement()
        assertEquals(0, viewModel.count.first())
    }

    @Test
    fun czero() = runBlockingTest {
        viewModel.increment()
        viewModel.increment()
        viewModel.reset()
        assertEquals(0, viewModel.count.first())
    }
}