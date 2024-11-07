package com.example.feature_mainpage_gui.ui.navigation.navBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.feature_mainpage_gui.ui.navigation.AppScreens


data class BottomNavItems(val route: AppScreens, val icon: ImageVector, val label: String)


val shortcuts = listOf(
    BottomNavItems(AppScreens.HOME, Icons.Default.Home, "Home"),
    BottomNavItems(AppScreens.COUNTER, Icons.Default.AddCircle, "Counter")
)

@Composable
fun BottomNavBar(navController: NavController) {

    NavigationBar () {
        shortcuts.forEach { shortcut ->
            NavigationBarItem(
                icon = { Icon(shortcut.icon, contentDescription = shortcut.label) },
                label = { Text(shortcut.label) },
                selected = getCurrentScreen(navController) == shortcut.route.name,
                onClick = { navController.navigate(shortcut.route.name) }
            )
        }
    }

}

@Composable
fun getCurrentScreen(navController: NavController): String {
    return navController.currentBackStackEntryAsState().value?.destination?.route.toString()
}