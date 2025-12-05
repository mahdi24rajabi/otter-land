package com.otterland.foundation.systeminfo

import android.app.Application
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import com.otterland.foundation.systeminfo.model.DisplayInfoModel

class DisplaySettingProvider(
    application: Application
) {
    private val resolver = application.contentResolver

    class SettingObserver(
        val onBrightnessChanged: () -> Unit,
        val onBrightnessAdjustmentMode: () -> Unit
    ) : ContentObserver(Handler(Looper.getMainLooper())) {
        override fun onChange(selfChange: Boolean, uri: Uri?) {
            super.onChange(selfChange, uri)
            uri?.encodedPath?.let { path ->
                when {
                    path.endsWith(Settings.System.SCREEN_BRIGHTNESS) -> {
                        onBrightnessChanged()
                    }

                    path.endsWith(Settings.System.SCREEN_BRIGHTNESS_MODE) -> {
                        onBrightnessAdjustmentMode()
                    }
                }
            }
        }
    }

    fun observeChanges(
        settingObserver: SettingObserver,
    ) {
        resolver.registerContentObserver(
            Settings.System.CONTENT_URI,
            true,
            settingObserver,
        )
    }

    fun stopObserveChanges(settingObserver: SettingObserver) {
        resolver.unregisterContentObserver(settingObserver)
    }

    fun isDisplayBrightnessAdjustmentManual() = Settings.System.getInt(
        resolver,
        Settings.System.SCREEN_BRIGHTNESS_MODE,
    ) == Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL

    fun enableManualDisplayBrightnessAdjustment() {
        Settings.System.putInt(
            resolver,
            Settings.System.SCREEN_BRIGHTNESS_MODE,
            Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
        )
    }

    fun disableManualDisplayBrightnessAdjustment() {
        Settings.System.putInt(
            resolver,
            Settings.System.SCREEN_BRIGHTNESS_MODE,
            Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
        )
    }

    fun getDisplayInfo(): DisplayInfoModel {
        val brightness = Settings.System.getInt(
            resolver,
            Settings.System.SCREEN_BRIGHTNESS
        )
        return DisplayInfoModel(
            brightness = brightness.toFloat(),
            manualBrightnessAdjustment = isDisplayBrightnessAdjustmentManual()
        )
    }

    fun setDisplayBrightness(brightness: Float) {
        Settings.System.putInt(
            resolver,
            Settings.System.SCREEN_BRIGHTNESS,
            brightness.toInt()
        )
    }
}