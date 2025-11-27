package com.otterland.foundation.design.efects

import android.app.UiModeManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun displayUiModeState(): UiModeState {
    val uiModeManager = LocalContext.current.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

    return when (uiModeManager.nightMode) {
        UiModeManager.MODE_NIGHT_NO -> UiModeState.DAY
        UiModeManager.MODE_NIGHT_YES -> UiModeState.NIGHT
        UiModeManager.MODE_NIGHT_AUTO -> UiModeState.AUTO
        else -> UiModeState.AUTO
    }
}

fun changeUiMode(context: Context, uiMode: UiModeState){
    if(Build.VERSION.SDK_INT > Build.VERSION_CODES.R){
        val uiModeManager = context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

        val platformUiModeCode = when(uiMode){
            UiModeState.DAY -> UiModeManager.MODE_NIGHT_NO
            UiModeState.NIGHT -> UiModeManager.MODE_NIGHT_YES
            UiModeState.AUTO -> UiModeManager.MODE_NIGHT_AUTO
        }

        uiModeManager.setApplicationNightMode(platformUiModeCode)
    } else {
        val platformUiModeCode = when(uiMode){
            UiModeState.DAY -> AppCompatDelegate.MODE_NIGHT_NO
            UiModeState.NIGHT -> AppCompatDelegate.MODE_NIGHT_YES
            UiModeState.AUTO -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }

        AppCompatDelegate.setDefaultNightMode(platformUiModeCode)
    }
}


enum class UiModeState {
    DAY,
    NIGHT,
    AUTO,
}