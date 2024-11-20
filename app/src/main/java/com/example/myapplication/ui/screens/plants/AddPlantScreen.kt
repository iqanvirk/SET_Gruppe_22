package com.example.myapplication.ui.screens.plants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.plant_icon1),
            contentDescription = "Plant Icon",
            modifier = Modifier
                .size(180.dp)
                .padding(top = 30.dp),
            tint = Color.Unspecified
        )


        Spacer(modifier = Modifier.height(60.dp))

        Text("Legg til ny plante", fontSize = 35.sp, color = OffWhite)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = plantName,
            onValueChange = { plantName = it },
            label = { Text("Navn", color = OffWhite) },
            placeholder = { Text("Skriv inn navn...", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = DarkBackground,
                focusedLabelColor = OffWhite,
                unfocusedLabelColor = Color.Gray,
                focusedBorderColor = OffWhite,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            value = plantVariety,
            onValueChange = { plantVariety = it },
            label = { Text("Sort", color = OffWhite) },
            placeholder = { Text("Skriv inn sort...", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = DarkBackground,
                focusedLabelColor = OffWhite,
                unfocusedLabelColor = Color.Gray,
                focusedBorderColor = OffWhite,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            value = plantingDate,
            onValueChange = { plantingDate = it },
            label = { Text("Plantningsdato", color = OffWhite) },
            placeholder = { Text("DD / MM / ÅÅÅÅ", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = DarkBackground,
                focusedLabelColor = OffWhite,
                unfocusedLabelColor = Color.Gray,
                focusedBorderColor = OffWhite,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { navController.popBackStack()
                      },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBackground,
                contentColor = OffWhite
            )
        ) {
            Text("Legg til")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlantScreenPreview() {
    AddPlantScreen(navController = NavController(LocalContext.current))
}
