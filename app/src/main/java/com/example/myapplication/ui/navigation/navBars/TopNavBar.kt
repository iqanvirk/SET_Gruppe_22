//Utgangspunkt tatt fra studentassistent Mats Hansen https://github.com/MobilprogrammeringH2024/Workshop02-Navigasjon/blob/main/app/src/main/java/com/example/workshopprosjekt/ui/navigation/navBars/TopBar.kt

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
import com.example.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, route: String? = null) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "PlantBuddy",
                textAlign = TextAlign.Center,
                color = MainGreen
            )
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = ColorManager.DarkBackground
        )


    )
}