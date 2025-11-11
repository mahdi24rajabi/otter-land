package com.otterland.playground.ui.activities.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.navigation.Route
import com.otterland.playground.ui.activities.ui.navigation.appScreenNavigationGraph

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
        startDestination = Route.Home,
    ) {
        appScreenNavigationGraph()
    }
}
