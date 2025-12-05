package com.otterland.feature.systeminfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otterland.feature.systeminfo.ui.screen.DisplayInfoScreen
import com.otterland.feature.systeminfo.ui.screen.SystemInfoScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Route() {
    @Serializable
    object SystemInfoList : Route()

    @Serializable
    object DisplayInfo : Route()

    @Serializable
    object MemoryInfo : Route()
}

fun NavGraphBuilder.createSystemInfoNavigationGraph(navigate: (Route) -> Unit) {
    composable<Route.SystemInfoList> { backStackEntry ->
        SystemInfoScreen { route ->
            navigate(route)
        }
    }
    composable<Route.DisplayInfo> {
        DisplayInfoScreen()
    }
}

@Composable
fun SystemInfoNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.SystemInfoList,
    ) {
        createSystemInfoNavigationGraph { route ->
            navController.navigate(route = route)
        }
    }
}