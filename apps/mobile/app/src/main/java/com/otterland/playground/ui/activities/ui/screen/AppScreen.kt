package com.otterland.playground.ui.activities.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.navigation.AppNavigation

@Preview
@Composable
fun AppScreenPreview() {
    OtterLandTheme {
        AppScreen()
    }
}

@Composable
fun AppScreen() {
    AppNavigation()
}
