@file:OptIn(ExperimentalMaterial3Api::class)

package com.outterland.feature.systeminfo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.otterland.foundation.design.component.Switch
import com.outterland.feature.systeminfo.DisplayInfoUiState
import com.outterland.feature.systeminfo.DisplayInfoViewModel
import com.outterland.feature.systeminfo.R

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
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DisplayInfoLayout(
    displayInfoState: DisplayInfoUiState,
    onBrightnessChanged: (Float) -> Unit = { _ -> },
    onManualBrightnessAdjustmentEnabled: (Boolean) -> Unit = { _ -> },
) {

    Column(
        modifier = Modifier.fillMaxSize()
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
                brightness = displayInfoState.brightness,
                enabled = displayInfoState.manualBrightnessAdjustment,
                onBrightnessChanged = { brightness ->
                    onBrightnessChanged(brightness)
                }
            )
            Switch(
                label = "Auto adjustment",
                checked = !displayInfoState.manualBrightnessAdjustment,
            ) { enabled ->
                onManualBrightnessAdjustmentEnabled(enabled)
            }
        }
    }
}

@Composable
fun DisplayBrightnessSlider(
    brightness: Float,
    enabled: Boolean,
    onBrightnessChanged: (Float) -> Unit
){
    var updateBrightnessByActualInputParameter by remember { mutableStateOf(true) }
    var sliderValue by remember { mutableStateOf(brightness) }

    when(updateBrightnessByActualInputParameter) {
        true -> sliderValue = brightness
        else -> {}
    }

    LaunchedEffect(sliderValue) {
        onBrightnessChanged(sliderValue)
    }

    Slider(
        value = sliderValue,
        valueRange = 0.0f..255.0f,
        steps = 0,
        onValueChange = { value ->
            updateBrightnessByActualInputParameter = false
            sliderValue = value
        },
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp,
            )
            .background(Color.Transparent)
            .fillMaxWidth()
            .wrapContentHeight(),
        enabled = enabled,
        onValueChangeFinished = {
            updateBrightnessByActualInputParameter = true
            onBrightnessChanged(sliderValue)
        },
        track = { sliderState ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ){
                Row (
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(sliderState.coercedValueAsFraction + 0.01f)
                            .background(
                                color = when {
                                    enabled -> MaterialTheme.colorScheme.onPrimary
                                    else -> MaterialTheme.colorScheme.onSurface
                                },
                                shape = RoundedCornerShape(
                                    topStart = 12.dp,
                                    bottomStart = 12.dp,
                                )
                            )
                    ) {
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1 - sliderState.coercedValueAsFraction + 0.01f)
                            .background(
                                color = when {
                                    enabled -> MaterialTheme.colorScheme.secondaryContainer
                                    else -> MaterialTheme.colorScheme.onSurface
                                },
                                shape = RoundedCornerShape(
                                    topEnd = 12.dp,
                                    bottomEnd = 12.dp,
                                )
                            )
                    ) { }
                }
                Icon(
                    painter = painterResource(R.drawable.ic_brightness),
                    contentDescription = "",
                    tint = when {
                        enabled -> MaterialTheme.colorScheme.primary
                        else -> MaterialTheme.colorScheme.primary.copy(alpha = 0.38f)
                    },
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 4.dp),
                )
            }
        }
    )

}