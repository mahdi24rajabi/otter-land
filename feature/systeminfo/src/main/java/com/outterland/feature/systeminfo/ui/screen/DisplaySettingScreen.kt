package com.outterland.feature.systeminfo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.otterland.foundation.design.component.SingleLineListItem
import com.outterland.feature.systeminfo.DisplayInfoUiState
import com.outterland.feature.systeminfo.DisplayInfoViewModel
import com.outterland.feature.systeminfo.R

@Composable
internal fun DisplayInfoScreen(
    displayInfoViewModel: DisplayInfoViewModel
) {

    val displayInfoFLow by displayInfoViewModel.displayInfoUiStateFlow.collectAsStateWithLifecycle()

    SideEffect {
        displayInfoViewModel.getDisplayInfo()
    }

    DisplayInfoLayout(
        displayInfoFLow
    ) { newBrightnessValue ->
        displayInfoViewModel.setBrightness(newBrightnessValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DisplayInfoLayout(
    displayInfoState: DisplayInfoUiState,
    onBrightnessChanged: (Float) -> Unit = { _ -> },
) {
    val lightSliderState = rememberSliderState(
        valueRange = 0f..1f,
        steps = 0,
        value = displayInfoState.brightness,
        onValueChangeFinished = {

        }
    )
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
            SingleLineListItem(
                iconResource = R.drawable.ic_brightness,
                label = "Brightness",
                false,
            ) { }
            Slider(
                value = 0.5f,
                valueRange = 0f..1f,
                track = {
                    SliderDefaults.Track(
                        sliderState = lightSliderState,
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.primary,
                            activeTrackColor = MaterialTheme.colorScheme.primary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                        trackInsideCornerSize = 8.dp,
                    )
                },
                steps = 0,
                onValueChange = {
                    onBrightnessChanged(it)
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp,
                    )
                    .fillMaxWidth()
                    .wrapContentHeight(),
                enabled = true,
            )
        }
    }
}