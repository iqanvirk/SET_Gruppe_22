package com.example.myapplication.ui.screens.plants

import FilterCheckbox
import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.models.Plant
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.theme.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPlantScreen(
    navController: NavController, context: Context, plant: Plant,
    viewModel: PlantScreenViewModel = viewModel()
) {
    var _plantName by remember { mutableStateOf(plant.name) }
    var plantType by remember { mutableStateOf(plant.sort) }
    var plantDate by remember { mutableStateOf(plant.plantDate) }
    var isError by remember { mutableStateOf(false) }
    var acceptChanges by remember { mutableStateOf(false) }
    var deletePlant by remember { mutableStateOf(false) }

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

            Text("Rediger " + plant.name, fontSize = 24.sp, color = ColorManager.TextColor)

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = _plantName,
                onValueChange = { _plantName = it },
                label = { Text("Plantenavn", color = ColorManager.TextColor) },
                //placeholder = { Text(plant.name, color = Color.Gray) },
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

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = plantType,
                onValueChange = { plantType = it },
                label = { Text("Plantetype", color = ColorManager.TextColor) },
                //placeholder = { Text(plant.sort, color = Color.Gray) },
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

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = plantDate,
                onValueChange = { if (it.length <= 10 && it.all { char -> char.isDigit() || char == '/' }) {
                    plantDate = it
                    isError = false
                } },
                label = { Text("Plantningsdato", color = ColorManager.TextColor) },
                //placeholder = { Text(plant.plantDate, color = Color.Gray) },
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

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    acceptChanges = true
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

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    deletePlant = true
                },
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp, vertical = 30.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorManager.LogoutBackground,
                    contentColor = ColorManager.LogoutTextColor
                )
            ) {
                Text("Slett plante")
            }
        }

        if (acceptChanges) {
            AlertDialog(
                onDismissRequest = { acceptChanges = false },
                title = { Text("Er du sikker på at du vil lagre?", color = ColorManager.TextColor) },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val parsedDate = parseDate(plantDate)
                            if (parsedDate != null) {
                                viewModel.editPlant(context, plant.id, _plantName, plantType, parsedDate)
                                navController.navigate(AppScreens.PLANT.name) {
                                    popUpTo(AppScreens.EDIT_PLANT.name) { inclusive = true }
                                }
                            } else {
                                isError = true
                                Toast.makeText(context, "Ugyldig datoformat", Toast.LENGTH_SHORT).show()
                            }
                            acceptChanges = false
                        }
                    ) {
                        Text("Ja", color = ColorManager.TextColor)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { acceptChanges = false }) {
                        Text("Nei", color = ColorManager.TextColor)
                    }
                },
                text = {
                    Text("Er du sikker på at du vil lagre endringene?", color = ColorManager.TextColor)
                },
                containerColor = ColorManager.Background
            )
        }

        if (deletePlant) {
            AlertDialog(
                onDismissRequest = { deletePlant = false },
                title = { Text("Er du sikker på at du vil slette?", color = ColorManager.TextColor) },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.deletePlant(context, plant.id)
                            navController.navigate(AppScreens.PLANT.name) {
                                popUpTo(AppScreens.EDIT_PLANT.name) { inclusive = true }
                            }
                            deletePlant = false
                        }
                    ) {
                        Text("Ja", color = ColorManager.TextColor)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { deletePlant = false }) {
                        Text("Nei", color = ColorManager.TextColor)
                    }
                },
                text = {
                    Text("Er du sikker på at du vil slette denne planten?", color = ColorManager.TextColor)
                },
                containerColor = ColorManager.Background
            )
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
//fun EditPlantScreen() {
//    EditPlantScreen(navController = NavController(LocalContext.current))
//}