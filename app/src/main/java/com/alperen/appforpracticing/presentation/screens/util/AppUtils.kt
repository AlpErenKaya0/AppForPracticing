package com.alperen.appforpracticing.presentation.screens.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.alperen.appforpracticing.ui.theme.Dimensions
import com.alperen.appforpracticing.ui.theme.Orientation
import com.alperen.appforpracticing.ui.theme.smallDimensions

@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () ->Unit
) {
    val dimSet = remember{dimensions}

    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf {
    smallDimensions
}

val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}