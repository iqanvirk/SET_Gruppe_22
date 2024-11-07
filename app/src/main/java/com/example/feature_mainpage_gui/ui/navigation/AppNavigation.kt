package com.example.feature_mainpage_gui.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature_mainpage_gui.ui.navigation.navBars.BottomNavBar
import com.example.feature_mainpage_gui.ui.navigation.navBars.TopBar
import com.example.feature_mainpage_gui.ui.screens.counter.CounterScreen
import com.example.feature_mainpage_gui.ui.screens.home.HomeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopBar(navController, route = AppScreens.HOME.name)
        },
        bottomBar = {
            BottomNavBar(navController)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreens.HOME.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(AppScreens.COUNTER.name) {
                CounterScreen()
            }

            composable(AppScreens.HOME.name) {
                HomeScreen(navController)
            }

        }

    }
}