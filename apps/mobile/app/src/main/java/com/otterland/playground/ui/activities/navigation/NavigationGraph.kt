package com.otterland.playground.ui.activities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Composable
fun createNavHost(
    navHostController: NavHostController,
) = NavHost(
        navHostController,
        startDestination = HomeScreen
    ) {
//        composable<HomeScreen> { Otter() }
    }
