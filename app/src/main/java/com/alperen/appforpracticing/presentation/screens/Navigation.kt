package com.alperen.appforpracticing.presentation.screens

import android.content.Intent
import com.alperen.appforpracticing.presentation.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alperen.appforpracticing.presentation.AppShortcutsScreen
import com.alperen.appforpracticing.presentation.FirstScreen
import com.alperen.appforpracticing.presentation.OnBoardingScreen
import com.alperen.appforpracticing.presentation.SecondScreen
import com.alperen.appforpracticing.presentation.ThirdScreen
import com.alperen.appforpracticing.presentation.ViewModels.AppShortcutViewModel
import com.alperen.appforpracticing.presentation.ViewModels.SplashActivityViewModel
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = Screen.SplashScreen.route ) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = "second_screen") {
            SecondScreen(navController = navController)
        }
        composable(route = "third_screen") {
            ThirdScreen(navController = navController)
        }
        composable(route = "splash_screen") {
            SplashScreen(navController = navController, viewModel = SplashActivityViewModel())
        }
        composable(route="app_shortcuts_screen"){
            AppShortcutsScreen(navController = navController, viewModel = AppShortcutViewModel(),
                //aşağıdaki intent doğru mu bilmiyorum
         intent = Intent())
        }
        composable(route = "on_boarding_screen") {
            OnBoardingScreen(navController=navController)
        }
    }

}