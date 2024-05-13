package com.alperen.appforpracticing.presentation
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alperen.appforpracticing.R
import com.alperen.appforpracticing.presentation.ViewModels.SplashActivityViewModel
import com.alperen.appforpracticing.presentation.screens.Navigation
import com.alperen.appforpracticing.presentation.screens.Screen
import com.alperen.appforpracticing.presentation.screens.ui.theme.AppForPracticingTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    val viewModel: SplashActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppForPracticingTheme {
                Navigation()
                }
            }
        }
    }




/*

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alperen.appforpracticing.R
import com.alperen.appforpracticing.ui.screens.ui.theme.AppForPracticingTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SplashScreenComp()
        }
    }
}

@Preview
@Composable
private fun SplashScreenComp() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Blue), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo_foreground),
            contentDescription = null
        )
    }
}
 */

