package com.otterland.foundation.design.component

import android.app.Activity
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
){
    val activity: Activity? = LocalActivity.current
    var showRationaleDialog by remember { mutableStateOf(false) }

    if(showRationaleDialog){
        PermissionRationaleDialog(
            title = "Permission request",
            reason = "${reason}",
            onDenied = {
                showRationaleDialog = false
                onDenied()
            },
            onApprove = {
                showRationaleDialog = false
            }
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { result ->
        when {
            result -> {
                onGranted()
            }
            activity.shouldShowPermissionRationale(permission = permission) -> {
                showRationaleDialog = true
            }
            else -> {
                showRationaleDialog = true
            }
        }
    }

    LaunchedEffect(permission) {
        permissionLauncher.launch(permission)
    }
}

private fun Activity?.shouldShowPermissionRationale(permission: String) =
    this?.shouldShowRequestPermissionRationale(permission) ?: false