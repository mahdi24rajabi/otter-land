package com.outterland.feature.systeminfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otterland.data.system.SystemRepository
import com.otterland.data.system.model.CPUInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SystemInfoViewModel @Inject constructor(
    val systemInfoRepository: SystemRepository
): ViewModel() {

    private val _cpuInfoUiStateFlow: MutableStateFlow<CPUInfoUiState> = MutableStateFlow<CPUInfoUiState>(
        CPUInfoUiState()
    )
    val cpuInfoUiStateFlow: StateFlow<CPUInfoUiState> = _cpuInfoUiStateFlow

    fun getCPUInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            systemInfoRepository.getCPUInfo()
                .asUiSate()
                .let {
                    _cpuInfoUiStateFlow.value = it
                }
        }
    }

    private fun CPUInfoModel.asUiSate() = CPUInfoUiState(
        hardware = this.hardware,
        manufacturer = this.manufacturer,
        numberOfCores = this.numberOfCores
    )

}