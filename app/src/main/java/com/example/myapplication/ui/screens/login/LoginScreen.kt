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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginScreenViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorManager.Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Text("Logg inn", fontSize = 24.sp, color = ColorManager.TextColor)

        Spacer(modifier = Modifier.height(24.dp))

        // Email input field
        OutlinedTextField(
            value = viewModel.userMail,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Mail", color = ColorManager.TextColor) },
            placeholder = { Text("Skriv inn mail...", color = Color.Gray) },
            textStyle = TextStyle(
                color = ColorManager.TextColor,
                fontSize = 16.sp
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
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

        // Password input field
        OutlinedTextField(
            value = viewModel.userPass,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Passord", color = ColorManager.TextColor) },
            placeholder = { Text("Skriv inn passord...", color = Color.Gray) },
            textStyle = TextStyle(
                color = ColorManager.TextColor,
                fontSize = 16.sp
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
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

        FilterCheckbox(
            label = "Husk meg",
            checked = viewModel.rememberUser,
            onCheckedChange = { viewModel.onRememberUserChange(it) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.onLoginClick()
                navController.navigate(AppScreens.HOME.name) {
                    popUpTo(AppScreens.LOGIN.name) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorManager.DarkBackground,
                contentColor = ColorManager.TextColor
            )
        ) {
            Text("Logg inn")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.onRegisterClick()
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
            Text("Registrer deg her")
        }
    }
}
