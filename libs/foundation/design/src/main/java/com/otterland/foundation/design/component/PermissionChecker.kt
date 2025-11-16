package com.otterland.foundation.design.component

import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun PermissionChecker(
    permission: String,
    reason: String?,
    onGranted: () -> Unit,
    onDenied: () -> Unit
) {
    var showRationale by remember { mutableStateOf(false) }
    var sendPermissionRequest by remember { mutableStateOf(false) }

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

    LaunchedEffect(sendPermissionRequest) {
        if (sendPermissionRequest) {
            permissionLauncher.launch(permission)
        }
    }

    when {
        LocalActivity.current.permissionIsGranted(permission) -> onGranted()
        !showRationale && LocalActivity.current.shouldShowPermissionRationale(
            permission
        ) -> {
            PermissionRationaleDialog(
                title = "Permission request",
                reason = "${reason}",
                onDenied = {
                    onDenied()
                },
                onApprove = {
                    sendPermissionRequest = true
                }
            )
        }
        else -> sendPermissionRequest = true
    }
}

private fun Activity?.shouldShowPermissionRationale(permission: String) =
    this?.shouldShowRequestPermissionRationale(permission) ?: false


private fun Activity?.permissionIsGranted(permission: String) =
    this?.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED