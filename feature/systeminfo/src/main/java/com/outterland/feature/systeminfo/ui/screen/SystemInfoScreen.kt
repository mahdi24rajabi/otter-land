package com.outterland.feature.systeminfo.ui.screen

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.component.ListCard
import com.otterland.foundation.design.component.PermissionChecker
import com.otterland.foundation.design.component.SingleLineListItem
import com.outterland.feature.systeminfo.R
import com.outterland.feature.systeminfo.ui.navigation.Route

internal enum class SystemInfoItem(
    val iconResource: Int,
    val label: String,
    val route: Route,
    val needsPermission: Boolean,
) {
    DISPLAY_INFO(
        iconResource = R.drawable.ic_brightness,
        label = "Display",
        needsPermission = true,
        route = Route.DisplayInfo,
    ),
    Storage(
        iconResource = R.drawable.ic_memory,
        label = "Storage",
        route = Route.DisplayInfo,
        needsPermission = true,
    ),
}

@Composable
internal fun SystemInfoScreen(navigate: (Route) -> Unit) {
    SystemInfoLayout {
        navigate(it.route)
    }
}

@Composable
internal fun SystemInfoLayout(onItemSelected: (SystemInfoItem) -> Unit) {
    var permissionRequested by remember {
        mutableStateOf(false)
    }

    if (permissionRequested) {
        PermissionChecker(
            permission = Manifest.permission.WRITE_SETTINGS,
            onGranted = {
                onItemSelected(SystemInfoItem.DISPLAY_INFO)
            },
            onDenied = {
                permissionRequested = false
            },
            reason = "The app needs your permission to adjust the display brightness."
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        ListCard(
            items = SystemInfoItem.entries,
            cardColors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow
            ),
            carElevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
            cardShape = CardDefaults.elevatedShape,
        ) { _, item ->
            key(item) {
                SingleLineListItem(
                    item.iconResource,
                    item.label,
                    true,
                ) {
                    if (item.needsPermission) {
                        permissionRequested = true
                    } else {
                        onItemSelected(item)
                    }
                }
            }
        }
    }
}