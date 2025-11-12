package com.outterland.feature.systeminfo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.component.ListCard
import com.otterland.foundation.design.component.SingleLineListItem
import com.otterland.foundation.design.theme.OtterLandTheme
import com.outterland.feature.systeminfo.CPUInfoUiState
import com.outterland.feature.systeminfo.R
import com.outterland.feature.systeminfo.SystemInfoViewModel

enum class SystemInfoItem(
    val iconResource: Int,
    val label: String,
    val screen: @Composable () -> Unit
) {
    DISPLAY_INFO(
        iconResource = R.drawable.ic_brightness,
        label = "Display",
        screen = {}
    ),
    Storage(
        iconResource = R.drawable.ic_memory,
        label = "Storage",
        screen = {}
    ),
}

@Composable
internal fun SystemInfoScreen(systemInfoViewModel: SystemInfoViewModel) {
    val cpuInfoUiState by systemInfoViewModel.cpuInfoUiStateFlow.collectAsState()

    SideEffect {
        systemInfoViewModel.getCPUInfo()
    }

    SystemInfoLayout(
        cpuInfoUiState = cpuInfoUiState,
    )
}

@Composable
internal fun SystemInfoLayout(
    cpuInfoUiState: CPUInfoUiState,
) {
    val cardColors =
        CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
    val cardElevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp)
    val cardShape = CardDefaults.elevatedShape

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        ListCard(
            items = SystemInfoItem.entries,
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        ) { _, item ->
            key(item) { }
            SingleLineListItem(
                item.iconResource,
                item.label,
                true,
            ) { }
        }
    }
}

@Preview
@Composable
fun SystemInfoLayoutPreview() {
    OtterLandTheme {
        SystemInfoLayout(CPUInfoUiState())
    }
}