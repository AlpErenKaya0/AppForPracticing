package com.alperen.appforpracticing.presentation

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alperen.appforpracticing.ui.ui.theme.AppForPracticingTheme

@Composable
fun SecondScreen(navController: NavController) {

    var darkMode by remember { mutableStateOf(true) }
    AppForPracticingTheme(darkTheme = darkMode) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Dark", fontSize = 45.sp)
                    Spacer(modifier = Modifier.padding(16.dp))
                    Switch(checked = darkMode, onCheckedChange = { darkMode = !darkMode })
                }

            }

        }
    }
}