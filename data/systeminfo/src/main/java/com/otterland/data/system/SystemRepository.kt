package com.otterland.data.system

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.hardware.display.DisplayManager
import com.otterland.data.system.model.CPUInfoModel
import kotlinx.coroutines.coroutineScope

class SystemRepository(
    application: Application
) {
    val displayManager = application.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

    suspend fun getCPUInfo() = coroutineScope {
        CPUInfoModel(
            numberOfCores = Runtime.getRuntime().availableProcessors(),
        )
    }

    suspend fun getDisplayInfo() = coroutineScope {
        displayManager.displays?.forEach {
//            it.cutout
        }
    }
}