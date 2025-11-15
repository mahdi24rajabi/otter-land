package com.outterland.feature.systeminfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otterland.data.system.SystemRepository
import com.otterland.data.system.model.CPUInfoModel
import com.otterland.data.system.model.DisplayInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DisplayInfoViewModel @Inject constructor(
    val systemRepository: SystemRepository
): ViewModel() {

    private val _displayInfoUiStateFlow: MutableStateFlow<DisplayInfoUiState> = MutableStateFlow<DisplayInfoUiState>(
        DisplayInfoUiState(0.0f)
    )
    val displayInfoUiStateFlow: StateFlow<DisplayInfoUiState> = _displayInfoUiStateFlow

    fun getCPUInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            systemRepository.getDisplayInfo()
                .asUiSate()
                .let {
                    _displayInfoUiStateFlow.value = it
                }
        }
    }

    fun getDisplayInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            systemRepository.getDisplayInfo()
                .asUiSate()
                .let {
                    _displayInfoUiStateFlow.value = it
                }
        }
    }

    private fun DisplayInfoModel.asUiSate() = DisplayInfoUiState(
        brightness = brightness
    )

    fun setBrightness(brightnessValue: Float) {
        viewModelScope.launch {
            systemRepository.setDisplayInfo(brightness = brightnessValue)
        }
    }

}