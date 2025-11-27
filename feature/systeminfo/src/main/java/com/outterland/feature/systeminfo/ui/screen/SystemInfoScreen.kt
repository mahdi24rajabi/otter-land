package com.outterland.feature.systeminfo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.component.ListCard
import com.otterland.foundation.design.component.SingleLineListItem
import com.outterland.feature.systeminfo.R
import com.outterland.feature.systeminfo.ui.navigation.Route

internal enum class SystemInfoItem(
    val iconResource: Int,
    val label: String,
    val route: Route,
) {
    DISPLAY_INFO(
        iconResource = R.drawable.ic_brightness,
        label = "Display",
        route = Route.DisplayInfo,
    ),
    Storage(
        iconResource = R.drawable.ic_memory,
        label = "Storage",
        route = Route.DisplayInfo,
    ),
}

@Composable
internal fun SystemInfoScreen(navigate: (Route) -> Unit) {
    SystemInfoLayout() {
        navigate(it.route)
    }
}

@Composable
internal fun SystemInfoLayout(
    onItemSelected: (SystemInfoItem) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp,
            )
    ) {
        ListCard(
            items = SystemInfoItem.entries,
            cardColors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow
            ),
            carElevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
            cardShape = CardDefaults.elevatedShape,
        ) { _, item ->
            key(item) {
                SingleLineListItem(
                    item.iconResource,
                    item.label,
                    true,
                ) {
                    onItemSelected(item)
                }
            }
        }
    }
}