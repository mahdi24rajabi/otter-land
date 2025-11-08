package com.otterland.data.system

import android.app.Application
import com.otterland.data.system.model.CPUModel
import kotlinx.coroutines.coroutineScope

class SystemRepository(
    val application: Application,
) {

    suspend fun getCPUInfo() = coroutineScope {
        CPUModel(
            architecture = "",
            cacheL1Size = 0L,
            numberOfCores = 4,
        )
    }
}