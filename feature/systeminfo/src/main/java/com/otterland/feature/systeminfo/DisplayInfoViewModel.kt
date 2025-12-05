package com.otterland.feature.systeminfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otterland.imageloader.systeminfo.DisplaySettingProvider
import com.otterland.imageloader.systeminfo.model.DisplayInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayInfoViewModel @Inject constructor(
    val displaySettingProvider: DisplaySettingProvider,
) : ViewModel() {
    private val observer = DisplaySettingProvider.SettingObserver(
        onBrightnessChanged = {
            displaySettingProvider.getDisplayInfo().let { displaySettingModel ->
                _displayInfoUiStateFlow.value = displaySettingModel.asUiSate()
            }
        },
        onBrightnessAdjustmentMode = {
            displaySettingProvider.getDisplayInfo().let { displaySettingModel ->
                _displayInfoUiStateFlow.value = displaySettingModel.asUiSate()
            }
        }
    )

    init {
        displaySettingProvider.observeChanges(observer)
    }

    private val _displayInfoUiStateFlow: MutableStateFlow<DisplayInfoUiState> = MutableStateFlow(
        displaySettingProvider.getDisplayInfo().asUiSate()
    )
    val displayInfoUiStateFlow: StateFlow<DisplayInfoUiState> =
        _displayInfoUiStateFlow.asStateFlow()

    fun setBrightnessAndUpdate(brightnessValue: Float) {
        viewModelScope.launch {
            displaySettingProvider.setDisplayBrightness(brightness = brightnessValue)
        }
    }

    override fun onCleared() {
        super.onCleared()
        displaySettingProvider.stopObserveChanges(observer)
    }

    fun enableManualDisplayAdjustment() {
        displaySettingProvider.enableManualDisplayBrightnessAdjustment()
    }

    fun disableManualDisplayAdjustment() {
        displaySettingProvider.disableManualDisplayBrightnessAdjustment()
    }
}

private fun DisplayInfoModel.asUiSate() = DisplayInfoUiState(
    brightness = brightness,
    manualBrightnessAdjustment = manualBrightnessAdjustment,
)