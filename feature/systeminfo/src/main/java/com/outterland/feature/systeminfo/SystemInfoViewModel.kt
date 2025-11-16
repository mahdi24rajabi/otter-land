package com.outterland.feature.systeminfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otterland.foundation.design.uistate.PermissionUiState
import com.otterland.foundation.permission.PermissionModel
import com.otterland.foundation.permission.SettingPermissionUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SystemInfoViewModel @Inject constructor(
    val settingPermissionUtils: SettingPermissionUtils,
) : ViewModel() {

    private val _askUserForPermission = MutableSharedFlow<PermissionUiState>()
    val askUserForPermission: SharedFlow<PermissionUiState> = _askUserForPermission

    fun getSettingPermission() {
        viewModelScope.launch {
            settingPermissionUtils.systemSettingPermission().asUiState().also {
                _askUserForPermission.emit(it)
            }
        }
    }
}

private fun PermissionModel.asUiState() = PermissionUiState(
    isGranted = this.isGranted,
    relatedExternalActivityIntent = this.relatedExternalActivityIntent,
    permission = this.permission,
    type = when(this.type){
        PermissionModel.Type.Runtime -> PermissionUiState.Type.Runtime
        PermissionModel.Type.Special -> PermissionUiState.Type.Special
    },
)