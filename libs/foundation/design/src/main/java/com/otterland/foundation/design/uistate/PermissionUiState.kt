package com.otterland.foundation.design.uistate

import android.content.Intent

data class PermissionUiState(
    val isGranted: Boolean,
    val relatedExternalActivityIntent: Intent,
    val permission: String,
    val type: Type,
){
    enum class Type {
        Special,
        Runtime,
        InstallTime;
    }
}