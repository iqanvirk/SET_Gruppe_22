package com.example.myapplication.ui.screens.plants

import FilterCheckbox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPlantScreen(navController: NavController) {
    var _plantName by remember { mutableStateOf("") }
    var plantType by remember { mutableStateOf("") }
    var plantDate by remember { mutableStateOf("") }

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(100.dp))

            Text("Rediger '$'plantName", fontSize = 24.sp, color = ColorManager.TextColor)

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = _plantName,
                onValueChange = { _plantName = it },
                label = { Text("Plantenavn", color = ColorManager.TextColor) },
                placeholder = { Text("Skriv inn plantenavn...", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = ColorManager.DarkBackground,
                    focusedLabelColor = ColorManager.TextColor,
                    unfocusedLabelColor = Color.Gray,
                    focusedBorderColor = ColorManager.TextColor,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = plantType,
                onValueChange = { plantType = it },
                label = { Text("Plantetype", color = ColorManager.TextColor) },
                placeholder = { Text("Skriv inn plantetype...", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = ColorManager.DarkBackground,
                    focusedLabelColor = ColorManager.TextColor,
                    unfocusedLabelColor = Color.Gray,
                    focusedBorderColor = ColorManager.TextColor,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = plantDate,
                onValueChange = { plantDate = it },
                label = { Text("Plantningsdato", color = ColorManager.TextColor) },
                placeholder = { Text("Skriv inn plantningsdato...", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = ColorManager.DarkBackground,
                    focusedLabelColor = ColorManager.TextColor,
                    unfocusedLabelColor = Color.Gray,
                    focusedBorderColor = ColorManager.TextColor,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorManager.DarkBackground,
                    contentColor = ColorManager.TextColor
                )
            ) {
                Text("Lagre")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditPlantScreen() {
    EditPlantScreen(navController = NavController(LocalContext.current))
}