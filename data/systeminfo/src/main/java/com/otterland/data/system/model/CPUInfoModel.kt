package com.otterland.data.system.model

import android.os.Build

data class CPUInfoModel(
    val numberOfCores: Int,
    val hardware: String = Build.HARDWARE,
    val manufacturer: String = Build.MANUFACTURER,
)
