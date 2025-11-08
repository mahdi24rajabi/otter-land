package com.otterland.OtterLand.ui.activities.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.navigation.AppScreen
import com.otterland.playground.ui.activities.ui.navigation.appScreenDestinations

@Preview
@Composable
fun OtterLandAppPreview() {
    OtterLandTheme {
        OtterLandApp()
    }
}

@Composable
fun OtterLandApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen,
    ) {
        appScreenDestinations(navController = navController)
    }
}
