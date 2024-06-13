package com.alperen.appforpracticing.presentation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.alperen.appforpracticing.R
import com.alperen.appforpracticing.presentation.ViewModels.AppShortcutViewModel
import com.alperen.appforpracticing.presentation.ViewModels.ShortcutType

@Composable
fun AppShortcutsScreen(
    navController: NavController,
    viewModel: AppShortcutViewModel) {
    val localContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp, Alignment.CenterVertically
        )
    ) {
        when (viewModel.shortcutType) {
            ShortcutType.STATIC -> Text(text = "static shortcut clicked")
            ShortcutType.DYNAMIC -> Text("Dynamic shortcut clicked")
            ShortcutType.PINNED -> Text("Pinned shortcut clicked")
            null -> Unit
        }
        Button(onClick = { addDynamicShortcut(localContext) }) {
            Text("Add dynamic shortcut")
        }
    }
}

private fun addDynamicShortcut(context: Context) {
    val shortcut = ShortcutInfoCompat.Builder(context, "dynamic")
        .setShortLabel("Dummy Shortcut")
        .setLongLabel("Clicking this will call dummy actions")
        .setIcon(IconCompat.createWithResource(context, R.drawable.baseline_360))
       //burası ile yapılacak işlemler
        .setIntent(
            Intent(context, SplashActivity::class.java).apply {
                action = Intent.ACTION_VIEW
                putExtra("shortcut_id", "dynamic")
            }
        )
        .build()
    ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
}
private fun handleIntent(intent: Intent?) {
    intent?.let {
        //alttaki satırla shortcut id statikse veya dinamikse sorgusu yapılıyor
        when(intent.getStringExtra("shortcut_id")) {}
    }
}
