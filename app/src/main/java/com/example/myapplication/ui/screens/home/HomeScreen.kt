package com.example.myapplication.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ColorManager
import java.time.LocalTime

@SuppressLint("NewApi")
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = viewModel()) {
    val currentTime = LocalTime.now()
    Box(
        modifier = Modifier
            .background(ColorManager.Background)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                // Top Greeting
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sunrise),
                        contentDescription = "Sol",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(110.dp)
                    )
                    Text(
                        text = viewModel.getTimeOfDay(LocalTime.now()),
                        color = ColorManager.TextColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
                SectionWithIcons(
                    title = "Nylig vannet",
                    iconItems = viewModel.recentWateredPlants
                )
            }

            item {
                WeatherSection(viewModel)
            }

            item {
                Section(
                    title = "Fare for planter"
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Warning Icon",
                            tint = Color(0xFFF69C04),
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = viewModel.plantDangerMessage,
                            color = ColorManager.TextColor,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SectionWithIcons(title: String, iconItems: List<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorManager.DarkBackground)
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = ColorManager.TextColor
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vanning),
                    contentDescription = "Watering Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(70.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconItems.forEach {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.plante_pote),
                                contentDescription = it,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                color = ColorManager.TextColor
                            )
                        }
                    }
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Icon",
                    tint = ColorManager.TextColor,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}

@Composable
fun WeatherSection(viewModel: HomeScreenViewModel) {
    Section(title = "Været idag") {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.rain_icon),
                contentDescription = "Weather Icon",
                tint = Color.Unspecified,
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Temperatur: ${viewModel.temperature}", color = ColorManager.TextColor, fontSize = 14.sp)
                Text("Værforhold: ${viewModel.weatherCondition}", color = ColorManager.TextColor, fontSize = 14.sp)
                Text("Nedbør: ${viewModel.precipitation}", color = ColorManager.TextColor, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorManager.DarkBackground)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = ColorManager.TextColor
            )
            content()
        }
    }
}