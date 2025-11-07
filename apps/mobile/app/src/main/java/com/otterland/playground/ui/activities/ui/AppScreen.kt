package com.otterland.OtterLand.ui.activities.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.OtterLandAppScreen

@Preview
@Composable
fun OtterLandAppPreview() {
    OtterLandApp()
}

private enum class DeviceType {
    COMPACT,
    MEDIUM,
    EXPANDED,
    LARGE,
    EXTRA_LARGE,
}

@Composable
fun OtterLandApp() {
//    createNavHost(navController)

    OtterLandTheme {
        OtterLandAppScreen()
    }
}
