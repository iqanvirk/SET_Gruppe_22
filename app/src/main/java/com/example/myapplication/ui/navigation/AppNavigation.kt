import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.navigation.navBars.BottomNavBar
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.navigation.navBars.TopBar
import com.example.myapplication.ui.screens.home.HomeScreen
import com.example.myapplication.ui.screens.login.LoginScreen
import com.example.myapplication.ui.screens.plants.AddPlantScreen
import com.example.myapplication.ui.screens.plants.EditPlantScreen
import com.example.myapplication.ui.screens.plants.PlantDetailsScreen
import com.example.myapplication.ui.screens.plants.PlantsScreen
import com.example.myapplication.ui.screens.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentScreen = getCurrentScreen(navController)

    Scaffold(
        topBar = {
            when (currentScreen) {
                AppScreens.IMAGE.name -> {
                    TopBar(navController, route = AppScreens.IMAGE.name)
                }
                else -> TopBar(navController)
            }
        },
        bottomBar = {
            if (currentScreen != AppScreens.LOGIN.name) {
                when (currentScreen) {
                    AppScreens.IMAGE.name -> {

                    }

                    else -> BottomNavBar(navController)
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreens.LOGIN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppScreens.PLANT.name) {
                PlantsScreen(navController)
            }

            composable(AppScreens.ADD_PLANT.name) {
                AddPlantScreen(navController)
            }

            composable(AppScreens.FILTER.name) {
                FilterScreen(navController)
            }

            composable(AppScreens.HOME.name) {
                HomeScreen(navController)
            }

            composable(AppScreens.SETTING.name) {
                SettingsScreen(navController)
            }

            composable(AppScreens.LOGIN.name) {
                LoginScreen(navController)
            }

            composable("plant_details/{plantName}") { backStackEntry ->
                val plantName = backStackEntry.arguments?.getString("plantName") ?: "Unknown"
                PlantDetailsScreen(navController = navController, plantName = plantName)
            }

            composable(AppScreens.EDIT_PLANT.name) {
                EditPlantScreen(navController = navController)
            }

        }
    }
}

@Composable
fun getCurrentScreen(navController: NavController): String {
    return navController.currentBackStackEntryAsState().value?.destination?.route.toString()
}


