package com.otterland.foundation.permission

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun PermissionChecker(
    permissionState: PermissionModel?,
    onGranted: () -> Unit,
    onDenied: () -> Unit
) {
    val activity = LocalActivity.current

    var permissionType by remember {
        mutableStateOf(PermissionModel.Type.InstallTime)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { result ->
        when {
            result -> {
                onGranted()
            }

            else -> onDenied()
        }
    }

    LaunchedEffect(permissionType) {
        permissionState?.let { permission ->
            when (permissionType) {
                PermissionModel.Type.Special -> {
                    activity.setSpecialPermissionRequest(permission.relatedExternalActivityIntent)
                }

                PermissionModel.Type.Runtime -> {
                    permissionLauncher.launch(permission.permission)
                }

                else -> {

                }
            }
        }
    }

    if (permissionState != null) {
        when {
            permissionState.grantState == PermissionModel.GrantState.GRANTED -> onGranted()
            LocalActivity.current.shouldShowPermissionRationale(
                permissionState.permission
            ) -> {
                PermissionRationaleDialog(
                    title = "Permission request",
                    reason = "",
                    onDenied = {
                        onDenied()
                    },
                    onApprove = {
                        permissionType = permissionState.type
                    }
                )
            }

            else -> {
                permissionType = permissionState.type
            }
        }
    }
}

private fun Activity?.shouldShowPermissionRationale(permission: String) =
    this?.shouldShowRequestPermissionRationale(permission) ?: false

private fun Activity?.setSpecialPermissionRequest(intent: Intent) {
    this?.startActivity(intent)
}