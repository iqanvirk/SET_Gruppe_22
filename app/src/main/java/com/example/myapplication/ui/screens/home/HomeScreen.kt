package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
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
import androidx.navigation.NavController
import com.example.myapplication.R


@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(Color(0xFF1F1F1F))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
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
                    text = "God morgen!",
                    color = Color(0xFFD2D2D2),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            SectionWithIcons(
                title = "Nylig vannet",
                iconItems = List(4) { "Plant" }
            )

            WeatherSection()

            Section(
                title = "Fare for planter"
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Warning Icon",
                        tint = Color.Yellow,
                        modifier = Modifier.size(70.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Innkommende flom!",
                        color = Color(0xFFD2D2D2),
                        fontSize = 16.sp
                    )
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
            .background(Color (0xFF1b1b1b))
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD2D2D2)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Watering Icon",
                    tint = Color.Cyan,
                    modifier = Modifier.size(70.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconItems.forEach {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = it,
                                tint = Color.Green,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                color = Color(0xFFD2D2D2)
                            )
                        }
                    }
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Icon",
                    tint = Color(0xFFD2D2D2),
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}

@Composable
fun WeatherSection() {
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
                Text("Temperatur: 12 °C", color = Color(0xFFD2D2D2), fontSize = 14.sp)
                Text("Værforhold: Regnbyger", color = Color(0xFFD2D2D2), fontSize = 14.sp)
                Text("Nedbør: 90%", color = Color(0xFFD2D2D2), fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color (0xFF1B1B1B))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD2D2D2)
            )
            content()
        }
    }
}