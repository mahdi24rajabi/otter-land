package com.otterland.foundation.permission

import android.content.Intent

data class PermissionModel(
    val grantState: GrantState,
    val relatedExternalActivityIntent: Intent,
    val permission: String,
    val type: Type,
) {
    enum class Type {
        Runtime,
        InstallTime,
        Special;
    }

    enum class GrantState {
        GRANTED,
        DENIED,
    }
}
