package com.example.myapplication.ui.navigation.navBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
import com.example.myapplication.ui.navigation.AppScreens

data class BottomNavItems(val route: AppScreens, val icon: Any, val label: String)

val shortcuts = listOf(
    BottomNavItems(AppScreens.HOME, Icons.Default.Home, "Hjem"),
    BottomNavItems(AppScreens.PLANT, R.drawable.plant_icon, "Planter"),
    BottomNavItems(AppScreens.SETTING, Icons.Default.Settings, "Innstillinger")
)

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF1B1B1B),
        contentColor = Color(0xFFD2D2D2)
    ) {
        shortcuts.forEach { shortcut ->
            val currentScreen = getCurrentScreen(navController) //== shortcut.route.name
            val isSelected = when (shortcut.route) {
                AppScreens.PLANT -> currentScreen == AppScreens.PLANT.name || currentScreen == AppScreens.FILTER.name // Gjør at filter siden også har planten highlighta, gjør filtersiden til en slags "sub-page" av plantesiden
                else -> currentScreen == shortcut.route.name
            }
            NavigationBarItem(
                icon = {
                    when (shortcut.icon) {
                        is ImageVector -> {
                            Icon(
                                imageVector = shortcut.icon,
                                contentDescription = shortcut.label,
                                tint = if (isSelected) Color(0xFF26A933) else Color(0xFFD2D2D2)
                            )
                        }
                        is Int -> {
                            Icon(
                                painter = painterResource(id = shortcut.icon),
                                contentDescription = shortcut.label,
                                tint = if (isSelected) Color(0xFF26A933) else Color(0xFFD2D2D2)
                            )
                        }
                    }
                },
                label = {
                    Text(
                        shortcut.label,
                        color = if (isSelected) Color(0xFF26A933) else Color(0xFFD2D2D2)
                    )
                },
                selected = isSelected,
                onClick = { navController.navigate(shortcut.route.name) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF00FF00),
                    unselectedIconColor = Color(0xFFD2D2D2),
                    selectedTextColor = Color(0xFF00FF00),
                    unselectedTextColor = Color(0xFFD2D2D2),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
@Composable
fun getCurrentScreen(navController: NavController): String {
    return navController.currentBackStackEntryAsState().value?.destination?.route.toString()
}