package com.alperen.appforpracticing.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.biometrics.BiometricManager
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alperen.appforpracticing.biometric.BiometricPromptManager
import com.alperen.appforpracticing.presentation.screens.Screen

@Composable
fun ThirdScreen(navController: NavController) {
     val promptManager by lazy{
        BiometricPromptManager(activity = AppCompatActivity())
    }
    Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    val biometricResult by promptManager.promptResult.collectAsState(initial = null)
                    val enrollLauncher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.StartActivityForResult(),
                        onResult= {
                            println("A")
                        }
                    )

                    LaunchedEffect(biometricResult) {
                        if (biometricResult  is BiometricPromptManager.BiometricResult.AuthenticationNotSet){
                            if (Build.VERSION.SDK_INT>30){
                                val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply{
                                    putExtra(
                                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                                        BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL
                                    )
                                }
                                enrollLauncher.launch(enrollIntent)
                            }
                        }

                    }
                    Column(modifier= Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Button(onClick={
                            promptManager.showBiometricPrompt(
                                title = "Sample Prompt",
                                description = "Sample"
                            )
                        })
                        {
                            Text(text ="Authenticate" )
                        }
                        biometricResult?.let {result->
                            Text(
                                text = when(result) {
                                    is BiometricPromptManager.BiometricResult.AuthenticationError->{
                                        result.error
                                    }
                                    BiometricPromptManager.BiometricResult.AuthenticationFailed->{
                                        "Auth Failed"
                                    }
                                    BiometricPromptManager.BiometricResult.AuthenticationNotSet->{
                                        "Auth NOT SET"
                                    }
                                    BiometricPromptManager.BiometricResult.AuthenticationSuccess->{
                                        "auth SUCCESS"
                                    }
                                    BiometricPromptManager.BiometricResult.FeatureUnavailable->{
                                        "Feature Unavailable"
                                    }
                                    BiometricPromptManager.BiometricResult.HardwareUnavailable->{
                                        "Hardware Unavailable"
                                    }

                                }
                            )

                        }
                    }
                    Column {
                        Button(onClick = {navController.navigate(Screen.AppShortcutsScreen.route)} ) {
                            Text(text ="go to another page")

                        }
                    }
                }
            }