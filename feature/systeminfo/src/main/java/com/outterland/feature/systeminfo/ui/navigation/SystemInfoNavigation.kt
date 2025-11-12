package com.outterland.feature.systeminfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.outterland.feature.systeminfo.SystemInfoViewModel
import com.outterland.feature.systeminfo.ui.screen.SystemInfoScreen
import kotlinx.serialization.Serializable

@Serializable
internal sealed class Route() {
    @Serializable
    object SystemInfoList: Route()
}

internal fun NavGraphBuilder.createSystemInfoNavigationGraph(){
    composable<Route.SystemInfoList> {
        val systemInfoViewModel: SystemInfoViewModel = hiltViewModel()
        SystemInfoScreen(
            systemInfoViewModel = systemInfoViewModel
        )
    }
}

@Composable
fun SystemInfoNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.SystemInfoList
    ){
        createSystemInfoNavigationGraph()
    }
}