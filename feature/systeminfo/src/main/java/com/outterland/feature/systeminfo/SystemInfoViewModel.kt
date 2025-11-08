package com.outterland.feature.systeminfo

import androidx.lifecycle.ViewModel
import com.otterland.data.system.SystemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SystemInfoViewModel @Inject constructor(
    systemInfoRepository: SystemRepository
): ViewModel() {



}