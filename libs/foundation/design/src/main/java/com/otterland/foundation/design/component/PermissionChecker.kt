package com.otterland.foundation.design.component

import android.Manifest
import android.app.Activity
import android.content.Intent
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
import com.otterland.foundation.design.uistate.PermissionUiState
import com.otterland.foundation.design.uistate.PermissionUiState.Type.*

@Composable
fun PermissionChecker(
    permissionState: PermissionUiState?,
    onGranted: () -> Unit,
    onDenied: () -> Unit
) {
    val activity = LocalActivity.current

    var permissionType by remember {
        mutableStateOf(InstallTime)
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
                Special -> {
                    activity.setSpecialPermissionRequest(permission.relatedExternalActivityIntent)
                }
                Runtime -> {
                    permissionLauncher.launch(permission.permission)
                }
                else -> {

                }
            }
        }
    }

    if(permissionState != null ) {
        when {
            permissionState.isGranted -> onGranted()
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