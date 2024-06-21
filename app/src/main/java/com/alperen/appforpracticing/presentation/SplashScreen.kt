package com.alperen.appforpracticing.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.alperen.appforpracticing.R
import com.alperen.appforpracticing.presentation.ViewModels.SplashActivityViewModel
import com.alperen.appforpracticing.presentation.screens.Screen
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashActivityViewModel
) {
    val alpha = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            1f,
            animationSpec = tween(1500)
        )
        delay(2000)
   //     navController.navigate(Screen.SecondScreen.route)
        navController.navigate(Screen.OnBoardingScreen.route)

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.alpha(alpha.value),
            painter = painterResource(id = R.drawable.logo_foreground),
            contentDescription = null
        )
    }
}

