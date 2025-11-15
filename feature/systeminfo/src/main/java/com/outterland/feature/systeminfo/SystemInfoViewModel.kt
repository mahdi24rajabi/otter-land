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
internal class SystemInfoViewModel @Inject constructor() : ViewModel()