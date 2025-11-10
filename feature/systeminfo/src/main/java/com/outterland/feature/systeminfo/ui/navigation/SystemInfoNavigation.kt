package com.outterland.feature.systeminfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.outterland.feature.systeminfo.SystemInfoViewModel
import com.outterland.feature.systeminfo.ui.SystemInfoScreen
import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object SystemInfo: Destinations()
}

internal fun NavGraphBuilder.createSystemInfoNavigationGraph(){
    composable<Destinations.SystemInfo> {
        val systemInfoViewModel: SystemInfoViewModel = hiltViewModel()
        SystemInfoScreen()
    }
}

@Composable
fun SystemInfoNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.SystemInfo
    ){
        createSystemInfoNavigationGraph()
    }
}