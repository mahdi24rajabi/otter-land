package com.otterland.playground.ui.activities.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.otterland.playground.ui.activities.ui.OtterLandHomeScreen
import kotlinx.serialization.Serializable

@Serializable
object AppScreen

fun NavGraphBuilder.appScreenDestinations() {
    composable<AppScreen> {
        OtterLandHomeScreen()
    }
}