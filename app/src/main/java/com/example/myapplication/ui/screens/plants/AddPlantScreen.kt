package com.example.myapplication.ui.screens.plants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlantScreen(navController: NavController) {
    var plantName by remember { mutableStateOf("") }
    var plantVariety by remember { mutableStateOf("") }
    var plantingDate by remember { mutableStateOf("") }

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
                .align(Alignment.TopCenter)
            ,
            tint = Color.Unspecified
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(45.dp))

            Text("Legg til ny plante", fontSize = 35.sp, color = ColorManager.TextColor)

            Spacer(modifier = Modifier.height(45.dp))

            OutlinedTextField(
                value = plantName,
                onValueChange = { plantName = it },
                label = { Text("Navn", color = ColorManager.TextColor) },
                placeholder = { Text("Skriv inn navn...", color = Color.Gray) },
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

            Spacer(modifier = Modifier.height(45.dp))

            OutlinedTextField(
                value = plantVariety,
                onValueChange = { plantVariety = it },
                label = { Text("Sort", color = ColorManager.TextColor) },
                placeholder = { Text("Skriv inn sort...", color = Color.Gray) },
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

            Spacer(modifier = Modifier.height(45.dp))

            OutlinedTextField(
                value = plantingDate,
                onValueChange = { plantingDate = it },
                label = { Text("Plantningsdato", color = ColorManager.TextColor) },
                placeholder = { Text("DD / MM / ÅÅÅÅ", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
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

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorManager.DarkBackground,
                    contentColor = ColorManager.TextColor
                )
            ) {
                Text("Legg til")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlantScreenPreview() {
    AddPlantScreen(navController = NavController(LocalContext.current))
}
