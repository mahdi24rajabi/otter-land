package com.otterland.playground.ui.activities.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otterland.playground.ui.activities.ui.screen.HomeScreen
import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    object Home: Route()
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home,
    ) {
        composable<Route.Home> {
            HomeScreen()
        }
    }
}