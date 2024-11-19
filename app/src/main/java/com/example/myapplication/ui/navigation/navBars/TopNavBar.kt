package com.example.myapplication.ui.navigation.navBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, route: String? = null) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "PlantBuddy",
                textAlign = TextAlign.Center,
                color = Color(0xFF26A933)
            )
        },

        navigationIcon = {
            IconButton(onClick = {
                if (route != null) {
                    navController.navigate(route)
                } else {
                    navController.popBackStack()
                }
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        },

        actions = {
            IconButton( onClick = {  } ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu button"
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF1B1B1B)
        )


    )
}