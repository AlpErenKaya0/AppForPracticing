package com.alperen.appforpracticing.presentation.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppShortcutViewModel:ViewModel() {
var shortcutType by mutableStateOf<ShortcutType?>(null)
    fun onShortcutClicked(type: ShortcutType) {
        shortcutType = type
    }
}
enum class ShortcutType {
    STATIC, DYNAMIC, PINNED
}