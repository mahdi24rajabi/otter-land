package com.otterland.data.system.model

data class CPUModel(
    val architecture: String,
    val numberOfCores: Int,
    val cacheL1Size: Long,
)
