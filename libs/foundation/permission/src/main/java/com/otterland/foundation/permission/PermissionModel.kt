package com.otterland.foundation.permission

import android.content.Intent

data class PermissionModel(
    val isGranted: Boolean,
    val relatedExternalActivityIntent: Intent,
    val permission: String,
    val type: Type,
){
    enum class Type{
        Runtime,
        Special;
    }
}
