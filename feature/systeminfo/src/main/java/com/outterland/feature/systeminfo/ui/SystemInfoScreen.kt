package com.outterland.feature.systeminfo.ui

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.outterland.feature.systeminfo.R

@Composable
@Preview
fun SystemInfoScreenPreview() {
    SystemInfoScreen()
}

enum class Category(
    val iconResourceId: Int
) {
    DEVICE_DETAILS(R.drawable.ic_cpu),
    HARDWARE(R.drawable.ic_cpu),
    DISPLAY(R.drawable.ic_display),
    NETWORK(R.drawable.ic_network),
    MEDIA_CODECS(R.drawable.ic_mediacodec),
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SystemInfoScreen() {

}