package com.alperen.appforpracticing.presentation.screens

sealed class Screen(val route:String) {
    object FirstScreen:Screen("first_screen")
    object SecondScreen:Screen("second_screen")
    object ThirdScreen:Screen(route = "third_screen")
    object SplashScreen:Screen("splash_screen")
}