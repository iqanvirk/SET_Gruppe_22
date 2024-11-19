package com.example.myapplication.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)),
        containerColor = Color(0xFF121212)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "Generelt:")
            SettingsItem(
                icon = painterResource(id = R.drawable.eye_icon),
                title = "Darkmode:",
                value = "Mørk",
                onClick = {
                }
            )
            HorizontalDivider(color = Color.White, thickness = 1.dp)
            SettingsItem(icon = painterResource(id = R.drawable.globe_icon), title = "Språk:", value = "Norsk")
            HorizontalDivider(color = Color.White, thickness = 1.dp)
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "FlexBox Example:")
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "Data:")
            SettingsItem(icon = painterResource(id = R.drawable.soppelbotte_icon), title = "Slett all plantedata")
            HorizontalDivider(color = Color.White, thickness = 1.dp)
            SettingsItem(icon = painterResource(id = R.drawable.nullstill_icon), title = "Nullstill Innstillinger")
            HorizontalDivider(color = Color.White, thickness = 1.dp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .width(230.dp)
            .background(Color(0xFF3E3E3E), RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        placeholder = { Text("Søk på innstilling...", color = Color.Gray) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFF1B1B1B),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(color = Color.White)
    )

    Icon(
        painter = painterResource(id = R.drawable.__icon__magnifying_glass_),
        contentDescription = "Search",
        tint = Color.Gray
    )
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun SettingsItem(
    icon: Any,
    title: String,
    value: String = "",
    onClick: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() }
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start
        ) {
            when (icon) {
                is ImageVector -> {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                is Painter -> {
                    Icon(
                        painter = icon,
                        contentDescription = title,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                else -> {
                    Text(text = "Invalid icon type", color = Color.Red)
                }
            }

            Spacer(modifier = Modifier.width(26.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 14.sp
            )
            if (value.isNotEmpty()) {
                Spacer(modifier = Modifier.weight(2f))
                Spacer(modifier = Modifier.width(45.dp))
                Text(
                    text = value,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.width(40.dp))
        Icon(
            painter = painterResource(id = R.drawable.chevron_right),
            contentDescription = "Navigate",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}