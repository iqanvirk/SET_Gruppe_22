package com.example.myapplication.ui.screens.plants

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.models.Plant
import com.example.myapplication.ui.theme.ColorManager
import com.google.gson.Gson

@Composable
fun PlantDetailsScreen(navController: NavController, plant: Plant) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorManager.Background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close button",
                tint = ColorManager.TextColor
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.plant_icon1),
            contentDescription = "Plant Icon",
            modifier = Modifier
                .size(180.dp)
                .padding(top = 20.dp)
                .align(Alignment.TopCenter),
            tint = Color.Unspecified
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = plant.name,
                fontSize = 35.sp,
                color = ColorManager.TextColor
            )

            Spacer(modifier = Modifier.height(45.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Type: " + plant.sort,
                    fontSize = 18.sp,
                    color = ColorManager.TextColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Dato plantet: " + plant.plantDate,
                    fontSize = 18.sp,
                    color = ColorManager.TextColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Sist vannet: 2 dager siden",
                    fontSize = 18.sp,
                    color = ColorManager.TextColor
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    val gson = Gson()
                    val plantJson = gson.toJson(plant)
                    navController.navigate("plant_edit/${Uri.encode(plantJson)}")
                    //navController.navigate(AppScreens.EDIT_PLANT.name)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(bottom = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorManager.DarkBackground,
                    contentColor = ColorManager.TextColor
                )
            ) {
                Text("Rediger plante")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PlantDetailsScreenPreview() {
//    PlantDetailsScreen(navController = NavController(LocalContext.current), plantName = "Plante 1")
//}
