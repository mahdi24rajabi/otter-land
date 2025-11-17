package com.otterland.data.system

import android.app.Application
import android.content.ContentUris
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.provider.UserDictionary
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
        val brightness = Settings.System.getFloat(
            application.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS
        )
        println("===============> ${brightness}")
        DisplayInfoModel(
            brightness = brightness
        )
    }

    suspend fun setDisplayInfo(brightness: Float) {
        Settings.System.putFloat(
            application.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            brightness
        )
    }
}