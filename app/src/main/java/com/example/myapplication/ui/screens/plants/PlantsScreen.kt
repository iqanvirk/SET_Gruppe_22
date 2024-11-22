package com.example.myapplication.ui.screens.plants

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.navigation.AppScreens
import com.example.myapplication.ui.theme.*
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PlantsScreen(
    navController: NavController, context: Context,
    viewModel: PlantScreenViewModel = viewModel()

) {
    LaunchedEffect(Unit) {
        viewModel.loadPlants(context)
    }

    val plants = viewModel.plants

    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = {
                            Text(
                                text = "Søk på navn, type...",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        },
                        textStyle = TextStyle(
                            color = ColorManager.TextColor,
                            fontSize = 16.sp
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = ColorManager.DarkBackground,
                            focusedLabelColor = ColorManager.TextColor,
                            unfocusedLabelColor = Color.Gray,
                            focusedBorderColor = ColorManager.TextColor,
                            unfocusedBorderColor = Color.Gray,
                            cursorColor = ColorManager.TextColor
                        ),

//
                        shape = RoundedCornerShape(8.dp),
                    )
                },
                navigationIcon = {
                    IconButton( onClick = { navController.navigate(AppScreens.FILTER.name) } ) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Filter button",
                            tint = ColorManager.TextColor
                        )
                    }
                },

                actions = {
                    IconButton( onClick = {  } ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search button",
                            tint = ColorManager.TextColor
                        )
                    }
                    IconButton( onClick = { navController.navigate(AppScreens.ADD_PLANT.name) } ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add button",
                            tint = ColorManager.TextColor
                        )
                    }
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = ColorManager.DarkBackground
                )


            )
        }
    ) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 48.dp,
                top = 48.dp + paddingValues.calculateTopPadding(),
                end = 48.dp,
                bottom = 48.dp + paddingValues.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(64.dp),
            horizontalArrangement = Arrangement.spacedBy(64.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(ColorManager.Background)
        ) {
            items(plants ?: emptyList()) { plant ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .clickable {
                            val gson = Gson()
                            val plantJson = gson.toJson(plant)
                            navController.navigate("plant_details/${Uri.encode(plantJson)}")
                        },
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(ColorManager.DarkBackground)
                    ) {
                        Text(text = plant.name, textAlign = TextAlign.Center, color = ColorManager.TextColor)
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PlantsScreenPreview() {
//    PlantsScreen(navController = NavController(LocalContext.current))
//}