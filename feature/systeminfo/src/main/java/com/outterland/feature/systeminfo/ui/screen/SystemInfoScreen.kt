package com.outterland.feature.systeminfo.ui.screen

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.collectFoldingFeaturesAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.otterland.foundation.design.component.ListCard
import com.otterland.foundation.design.component.PermissionChecker
import com.otterland.foundation.design.component.SingleLineListItem
import com.otterland.foundation.design.uistate.PermissionUiState
import com.outterland.feature.systeminfo.R
import com.outterland.feature.systeminfo.SystemInfoViewModel
import com.outterland.feature.systeminfo.ui.navigation.Route
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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
    val systemInfoViewModel: SystemInfoViewModel = hiltViewModel()

    SystemInfoLayout(
        askUserForThePermissionStateFlow = systemInfoViewModel.askUserForPermission,
        requestSettingPermission = {
            systemInfoViewModel.getSettingPermission()
        }
    ) {
        navigate(it.route)
    }
}

@Composable
internal fun SystemInfoLayout(
    askUserForThePermissionStateFlow: SharedFlow<PermissionUiState>,
    requestSettingPermission: () -> Unit,
    onItemSelected: (SystemInfoItem) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var permissionUiState by remember {
        mutableStateOf<PermissionUiState?>(null)
    }

    var requestPermissionForItem by remember {
        mutableStateOf<SystemInfoItem?>(null)
    }

    LaunchedEffect(Unit) {
        askUserForThePermissionStateFlow.collect {
            permissionUiState = it
        }
    }

    LaunchedEffect(requestPermissionForItem) {
        when (requestPermissionForItem) {
            SystemInfoItem.DISPLAY_INFO -> requestSettingPermission()
            else -> {}
        }
    }


    PermissionChecker(
        permissionState = permissionUiState,
        onDenied = {

        },
        onGranted = {
            requestPermissionForItem?.let {
                onItemSelected(it)
            }
        }
    )

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
                        requestPermissionForItem = item
                    } else {
                        onItemSelected(item)
                    }
                }
            }
        }
    }
}