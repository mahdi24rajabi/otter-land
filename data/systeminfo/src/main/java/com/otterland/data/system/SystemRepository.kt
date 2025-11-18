package com.otterland.data.system

import android.app.Application
import android.content.ContentUris
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.provider.UserDictionary
import android.view.WindowManager
import com.otterland.data.system.model.DisplayInfoModel
import kotlinx.coroutines.coroutineScope

class SystemRepository(
    val application: Application
) {

    init {
        Settings.System.putInt(
            application.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS_MODE,
            Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
        )
    }

    suspend fun getDisplayInfo() = coroutineScope {
        val brightness = Settings.System.getInt(
            application.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS
        )
        DisplayInfoModel(
            brightness = brightness.toFloat()
        )
    }

    suspend fun setDisplayInfo(brightness: Float) {
        Settings.System.putInt(
            application.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            brightness.toInt()
        )
    }
}