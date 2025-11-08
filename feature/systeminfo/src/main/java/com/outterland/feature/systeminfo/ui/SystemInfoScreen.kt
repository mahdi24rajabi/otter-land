package com.outterland.feature.systeminfo.ui

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.outterland.feature.systeminfo.R

@Composable
@Preview
fun SystemInfoScreenPreview() {
    SystemInfoScreen()
}

enum class Category(
    val iconResourceId: Int
) {
    CPU(R.drawable.ic_cpu),
    Display(R.drawable.ic_display),
    Network(R.drawable.ic_network),
    MediaCodecs(R.drawable.ic_mediacodec),
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SystemInfoScreen(
    navController: NavController = rememberNavController()
) {

}