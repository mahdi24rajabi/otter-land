package com.otterland.foundation.permission

import android.Manifest
import android.app.Application
import android.content.Intent
import android.net.Uri
import android.provider.Settings

class SettingPermissionUtils(
    val application: Application
) {

    fun systemSettingPermission() = PermissionModel(
        type = PermissionModel.Type.Special,
        isGranted = Settings.System.canWrite(application),
        permission = Manifest.permission.WRITE_SETTINGS,
        relatedExternalActivityIntent = Intent(
            Settings.ACTION_MANAGE_WRITE_SETTINGS,
        ).apply {
            data = Uri.parse("package:${application.packageName}")
        }
    )

}