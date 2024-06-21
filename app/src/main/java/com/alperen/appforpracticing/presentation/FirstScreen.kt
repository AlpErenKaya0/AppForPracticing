package com.alperen.appforpracticing.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alperen.appforpracticing.presentation.screens.Screen

@Composable
fun FirstScreen(navController: NavController) {
    Button(
        onClick = { navController.navigate(Screen.SecondScreen.route) }
    ) {
        Text(text = "Go to Another Screen")
    }
}