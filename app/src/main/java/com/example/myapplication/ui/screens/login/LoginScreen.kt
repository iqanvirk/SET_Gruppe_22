package com.example.myapplication.ui.screens.login

import FilterCheckbox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
fun LoginScreen(navController: NavController) {
    var userMail by remember { mutableStateOf("") }
    var userPass by remember { mutableStateOf("") }
    var rememberUser by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Text("Logg inn", fontSize = 24.sp, color = OffWhite)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userMail,
            onValueChange = { userMail = it },
            label = { Text("Mail", color = OffWhite) },
            placeholder = { Text("Skriv inn mail...", color = Color.Gray) },
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

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = userPass,
            onValueChange = { userPass = it },
            label = { Text("Passord", color = OffWhite) },
            placeholder = { Text("Skriv inn passord...", color = Color.Gray) },
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

        Spacer(modifier = Modifier.height(20.dp))

        FilterCheckbox(label = "Husk meg", checked = rememberUser, onCheckedChange = { rememberUser = it })

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(AppScreens.HOME.name) {
                    popUpTo(AppScreens.LOGIN.name) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBackground,
                contentColor = OffWhite
            )
        ) {
            Text("Logg inn")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBackground,
                contentColor = OffWhite
            )
        ) {
            Text("Registrer deg her")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}