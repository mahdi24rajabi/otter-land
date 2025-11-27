@file:OptIn(ExperimentalMaterial3Api::class)

package com.outterland.feature.systeminfo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.otterland.foundation.design.component.ListItemSwitch
import com.otterland.foundation.permission.PermissionChecker
import com.otterland.foundation.permission.PermissionModel
import com.otterland.foundation.permission.systemSettingPermission
import com.outterland.feature.systeminfo.DisplayInfoUiState
import com.outterland.feature.systeminfo.DisplayInfoViewModel
import com.outterland.feature.systeminfo.R
import com.outterland.feature.systeminfo.ui.component.DisplayBrightnessSlider
import com.outterland.feature.systeminfo.ui.component.UiModeSwitch

@Composable
internal fun DisplayInfoScreen() {
    val displayInfoViewModel: DisplayInfoViewModel = hiltViewModel()
    val displaySettingInfo by displayInfoViewModel.displayInfoUiStateFlow.collectAsState()

    DisplayInfoLayout(
        displayInfoState = displaySettingInfo,
        onBrightnessChanged = { newBrightnessValue ->
            displayInfoViewModel.setBrightnessAndUpdate(newBrightnessValue)
        },
        onManualBrightnessAdjustmentEnabled = { enabled ->
            if (enabled) {
                displayInfoViewModel.enableManualDisplayAdjustment()
            } else {
                displayInfoViewModel.disableManualDisplayAdjustment()
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DisplayInfoLayout(
    displayInfoState: DisplayInfoUiState,
    onBrightnessChanged: (Float) -> Unit = { _ -> },
    onManualBrightnessAdjustmentEnabled: (Boolean) -> Unit = { _ -> },
) {
    var settingWritePermissionState by remember {
        mutableStateOf(PermissionModel.GrantState.DENIED)
    }

    PermissionChecker(
        permissionState = systemSettingPermission(),
        onDenied = {
            settingWritePermissionState = PermissionModel.GrantState.DENIED
        },
        onGranted = {
            settingWritePermissionState = PermissionModel.GrantState.GRANTED
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp,
            )
    ) {
        Card(
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow
            ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
            shape = CardDefaults.elevatedShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.dakr_light_mode,
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .height(240.dp)
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                        .clip(CardDefaults.elevatedShape),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillHeight,
                )
                HorizontalDivider(
                    color = Color.Transparent,
                    thickness = 16.dp,
                )
                UiModeSwitch(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
            }
        }

        BrightnessLayout(
            permissionState = settingWritePermissionState,
            brightness = displayInfoState.brightness,
            manualBrightnessAdjustment = displayInfoState.manualBrightnessAdjustment,
            onBrightnessChanged = onBrightnessChanged,
            onManualBrightnessAdjustmentEnabled = onManualBrightnessAdjustmentEnabled
        )
    }
}

@Composable
internal fun BrightnessLayout(
    permissionState: PermissionModel.GrantState,
    brightness: Float,
    manualBrightnessAdjustment: Boolean,
    onBrightnessChanged: (Float) -> Unit,
    onManualBrightnessAdjustmentEnabled: (Boolean) -> Unit
) {
    Card(
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = 8.dp,
                bottom = 8.dp,
            )
    ) {
        DisplayBrightnessSlider(
            brightness = brightness,
            enabled = permissionState == PermissionModel.GrantState.GRANTED && manualBrightnessAdjustment,
            onBrightnessChanged = { brightness ->
                onBrightnessChanged(brightness)
            }
        )
        ListItemSwitch(
            label = "Auto adjustment",
            checked = !manualBrightnessAdjustment,
            enabled = permissionState == PermissionModel.GrantState.GRANTED,
        ) { checked ->
            onManualBrightnessAdjustmentEnabled(checked)
        }
    }
}