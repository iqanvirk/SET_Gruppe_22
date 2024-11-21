package com.example.myapplication.ui.screens.plants

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.example.myapplication.ui.theme.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlantScreen(
    navController: NavController, context: Context,
    viewModel: PlantScreenViewModel = viewModel()
) {
    var plantName by remember { mutableStateOf("") }
    var plantVariety by remember { mutableStateOf("") }
    var plantingDate by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

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
                .zIndex(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close button",
                tint = ColorManager.TextColor
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            item {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.plant_icon1),
                    contentDescription = "Plant Icon",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(top = 20.dp),
                    tint = Color.Unspecified
                )
            }

            item {
                Text("Legg til ny plante", fontSize = 35.sp, color = ColorManager.TextColor)
            }

            item {
                OutlinedTextField(
                    value = plantName,
                    onValueChange = { plantName = it },
                    label = { Text("Navn", color = ColorManager.TextColor) },
                    placeholder = { Text("Skriv inn navn...", color = Color.Gray) },
                    textStyle = TextStyle(
                        color = ColorManager.TextColor,
                        fontSize = 16.sp
                    ),
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
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = ColorManager.TextColor
                    )
                )
            }

            item {
                OutlinedTextField(
                    value = plantVariety,
                    onValueChange = { plantVariety = it },
                    label = { Text("Sort", color = ColorManager.TextColor) },
                    placeholder = { Text("Skriv inn sort...", color = Color.Gray) },
                    textStyle = TextStyle(
                        color = ColorManager.TextColor,
                        fontSize = 16.sp
                    ),
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
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = ColorManager.TextColor
                    )
                )
            }

            item {
                OutlinedTextField(
                    value = plantingDate,
                    onValueChange = {
                        if (it.length <= 10 && it.all { char -> char.isDigit() || char == '/' }) {
                            plantingDate = it
                            isError = false
                        }
                    },
                    label = { Text("Plantningsdato", color = ColorManager.TextColor) },
                    placeholder = { Text("DD / MM / ÅÅÅÅ", color = Color.Gray) },
                    textStyle = TextStyle(
                        color = ColorManager.TextColor,
                        fontSize = 16.sp
                    ),
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
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = ColorManager.TextColor
                    )
                )
            }

            item {
                Button(
                    onClick = {
                        val parsedDate = parseDate(plantingDate)
                        if (parsedDate != null) {
                            viewModel.addPlant(context, plantName, plantVariety, parsedDate)
                            navController.popBackStack()
                        } else {
                            isError = true
                            Toast.makeText(context, "Invalid Date Format", Toast.LENGTH_SHORT).show()
                        }
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
}

private fun parseDate(input: String): Date? {
    return try {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        formatter.isLenient = false
        formatter.parse(input)
    } catch (e: Exception) {
        null
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AddPlantScreenPreview() {
//    AddPlantScreen(navController = NavController(LocalContext.current))
//}
