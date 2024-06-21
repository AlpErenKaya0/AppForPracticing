package com.alperen.appforpracticing.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alperen.appforpracticing.presentation.screens.Screen

@Composable
fun OnBoardingScreen(navController: NavController) {
Button(onClick = {navController.navigate(Screen.FirstScreen.route)} ) {
    Text(text ="go to another page")

}
}