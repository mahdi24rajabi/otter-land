package com.otterland.playground.ui.activities.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.otterland.playground.ui.activities.ui.HomeScreen
import kotlinx.serialization.Serializable


sealed class Route {
    @Serializable
    object Home: Route()
}

fun NavGraphBuilder.appScreenNavigationGraph() {
    composable<Route.Home> {
        HomeScreen()
    }
}