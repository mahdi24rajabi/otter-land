package com.otterland.imageloader.permission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@Composable
fun systemSettingPermission(): PermissionModel {
    val context = LocalContext.current
    val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS).apply {
        data = Uri.parse("package:${context.packageName}")
    }

    val grantState = if (Settings.System.canWrite(context)) {
        PermissionModel.GrantState.GRANTED
    } else {
        PermissionModel.GrantState.DENIED
    }

    return PermissionModel(
        type = PermissionModel.Type.Special,
        grantState = grantState,
        permission = Manifest.permission.WRITE_SETTINGS,
        relatedExternalActivityIntent = intent
    )
}

@Composable
fun systemSecurityPermission(): PermissionModel {
    val context = LocalContext.current
    val isGranted =
        if (context.checkSelfPermission(Manifest.permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
            PermissionModel.GrantState.GRANTED
        } else {
            PermissionModel.GrantState.DENIED
        }

    val intent = Intent(
        Settings.ACTION_MANAGE_WRITE_SETTINGS,
    ).apply {
        data = Uri.parse("package:${context.packageName}")
    }

    return PermissionModel(
        type = PermissionModel.Type.Special,
        grantState = isGranted,
        permission = Manifest.permission.WRITE_SECURE_SETTINGS,
        relatedExternalActivityIntent = intent
    )
}
