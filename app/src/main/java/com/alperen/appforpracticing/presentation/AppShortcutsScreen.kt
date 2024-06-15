package com.alperen.appforpracticing.presentation

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
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
import androidx.core.content.ContextCompat.getSystemService
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
    viewModel: AppShortcutViewModel,
    intent: Intent?
) {
    val localContext = LocalContext.current
    //aşağıdaki handleIntent normalde onCreate içinde yapılıyor eğer tekrarlanırsa onNewIntent
    handleIntent(intent, viewModel)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp, Alignment.CenterVertically
        )
    ) {
        when (viewModel.shortcutType) {
            //burada neden text çıkmıyor? Tıklanınca
            ShortcutType.STATIC -> Text(text = "Static shortcut clicked")
            ShortcutType.DYNAMIC -> Text("Dynamic shortcut clicked")
            ShortcutType.PINNED -> Text("Pinned shortcut clicked")
            null -> Unit
        }
        Button(onClick = { addDynamicShortcut(localContext) }) {
            Text("Add dynamic shortcut")
        }
        Button(onClick = { addPinnedShortcut(localContext) }) {
            Text("Add pinned shortcut")
        }
    }
}
//aşağıdaki yapı onCreate'de yapılan işlemden kaynaklı override ile yapıldı,
// o yüzden incelemek gerek
/*
override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    handleIntent(intent)
}
*/
private fun addPinnedShortcut(context: Context){
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
        return
    }
    //alttaki satırdan emin değilim normalde şu şekilde yazılıyordu ama context istiyor
    // = val shortcutManager = getSystemService<ShortcutManager>(context)!!
    val shortcutManager = context.getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager
        val shortcut = ShortcutInfo.Builder(context, "pinned")
            .setShortLabel("Send message")
            .setLongLabel("This sends a message to a friend")
            .setIcon(Icon.createWithResource(
                context, R.drawable.baseline_360
            )).setIntent(
                Intent(context, SplashActivity::class.java).apply {
                action = Intent.ACTION_VIEW
                putExtra("shortcut_id", "dynamic")
            }
            ).build()
        val callBackIntent = shortcutManager.createShortcutResultIntent(shortcut)
        val successPendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            callBackIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        shortcutManager.requestPinShortcut(shortcut,successPendingIntent.intentSender)
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

private fun handleIntent(intent: Intent?, viewModel: AppShortcutViewModel) {
    intent?.let {
        //alttaki satırla shortcut id statikse veya dinamikse sorgusu yapılıyor
        when (intent.getStringExtra("shortcut_id")) {
            "static" -> viewModel.onShortcutClicked(ShortcutType.STATIC)
            "dynamic" -> viewModel.onShortcutClicked(ShortcutType.DYNAMIC)
            "pinned" -> viewModel.onShortcutClicked(ShortcutType.PINNED)
        }
    }
}
//not shortcut'da ismi salladım, string app name olabilir orada xmldeki shortcutta
//not: pagedirector'a dea manifestteki yok diyor