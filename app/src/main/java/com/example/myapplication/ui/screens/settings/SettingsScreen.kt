package com.example.myapplication.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.theme.*


@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorManager.Background),
        containerColor = ColorManager.Background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(19.dp)
        ) {
            SearchBar() // kaller på søkefelt composable og viser den
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "Generelt:")
            SettingsItem(icon = painterResource(
                id = R.drawable.eye_icon),
                title = if (ColorManager.isDarkMode) "Mørkmodus" else "Lysmodus",
                value = if (ColorManager.isDarkMode) "Mørk" else "Lys",
                onClick = {
                    ColorManager.isDarkMode = !ColorManager.isDarkMode
                }
            )
            HorizontalDivider(color = ColorManager.TextColor, thickness = 1.dp)
            SettingsItem(icon = painterResource(id = R.drawable.globe_icon), title = "Språk", value = "Norsk") // Tekst og ikon for slett språk
            HorizontalDivider(color = ColorManager.TextColor, thickness = 1.dp)
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "Data:")
            SettingsItem(icon = painterResource(id = R.drawable.soppelbotte_icon), title = "Slett all plantedata") // Tekst og ikon for slett plantedata
            HorizontalDivider(color = ColorManager.TextColor, thickness = 1.dp)
            SettingsItem(icon = painterResource(id = R.drawable.nullstill_icon), title = "Nullstill Innstillinger") // Tekst og ikon for nullstill innstillinger
            HorizontalDivider(color = ColorManager.TextColor, thickness = 1.dp)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate(AppScreens.LOGIN.name) {
                        popUpTo(AppScreens.SETTING.name) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp, vertical = 0.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorManager.LogoutBackground,
                    contentColor = ColorManager.LogoutTextColor
                )
            ) {
                Text("Logg ut")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    // lagring av tekst verdi i søkefelt
    val searchText = remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth() // full bredde rad
            .background(ColorManager.DarkBackground, RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Border på søkefelt
            .padding(horizontal = 8.dp, vertical = 4.dp), // padding inni søkefeltet
        verticalAlignment = Alignment.CenterVertically
    ) {
        // tekstfeld ta i mot brukerinput
        TextField(
            value = searchText.value,  // bruk `searchText.value` for å ta tak i verdien akkurat nå i søkefelt
            onValueChange = { newText -> searchText.value = newText }, // oppdater statusvedi
            modifier = Modifier
                .weight(1f)
                .background(Color.Transparent),
            placeholder = { Text("Søk på innstilling...", color = Color.Gray) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = ColorManager.TextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                color = ColorManager.TextColor,
                fontSize = 16.sp
            ),
        )

        Spacer(modifier = Modifier.width(8.dp)) // Spacer mellom tekstfelt og ikon

        // søke ikon til høyre
        Icon(
            painter = painterResource(id = R.drawable.__icon__magnifying_glass_),
            contentDescription = "Search",
            tint = Color.Gray,
            modifier = Modifier.size(20.dp) // endrer på icon størrelsen
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = ColorManager.TextColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun SettingsItem(
    icon: Any, //ImageVector til painter og Icon
    title: String,
    value: String = "",
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.weight(1f), // jevnlig fordeling av innhold
            horizontalArrangement = Arrangement.Start // posisjonerer innhold til venstre
        ) {
            when (icon) {  //Kode for å skille mellom material design 3 ikoner og custom importerte ikoner
                is ImageVector -> {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = ColorManager.TextColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
                is Painter -> {
                    Icon(
                        painter = icon,
                        contentDescription = title,
                        tint = ColorManager.TextColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
                else -> {
                    Text(text = "Invalid icon type", color = Color.Red)
                }
            } //Slutt på kodeblokk som skiller ikoner

            Spacer(modifier = Modifier.width(26.dp)) // mellomrom mellom ikon og tekst
            Text(
                text = title,
                color = ColorManager.TextColor,
                fontSize = 14.sp,
            )
        }

        Spacer(modifier = Modifier.width(40.dp)) // mellomrom mellom tekst og pil
        Icon(
            painter = painterResource(id = R.drawable.chevron_right), // Pil ikon
            contentDescription = "Navigate",
            tint = ColorManager.TextColor,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = NavController(LocalContext.current)) // kall på koden uten dark mode parametere
}
