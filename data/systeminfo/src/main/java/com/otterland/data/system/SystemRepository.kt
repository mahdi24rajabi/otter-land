package com.otterland.data.system

import android.app.Application
import android.provider.Settings
import com.otterland.data.system.model.DisplayInfoModel
import kotlinx.coroutines.coroutineScope

class SystemRepository(
    application: Application
) {
    private val contentResolver = application.contentResolver

    suspend fun getDisplayInfo() = coroutineScope {
        DisplayInfoModel(
            brightness = Settings.System.getFloat(
                contentResolver,
                Settings.System.SCREEN_BRIGHTNESS
            )
        )
    }

    suspend fun setDisplayInfo(brightness: Float) {
        Settings.System.putFloat(
            contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            brightness
        )
    }
}