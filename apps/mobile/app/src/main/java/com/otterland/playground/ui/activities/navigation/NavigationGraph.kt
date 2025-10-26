package com.otterland.playground.ui.activities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otterland.OtterLand.ui.activities.ui.OtterLandHomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Composable
fun createNavHost(
    navHostController: NavHostController = rememberNavController(),
) = NavHost(
        navHostController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> { OtterLandHomeScreen() }
    }
