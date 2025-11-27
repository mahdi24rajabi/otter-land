package com.otterland.playground.ui.activities.ui.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.WideNavigationRailDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun navigationSuiteColors() = NavigationSuiteDefaults.colors(
    shortNavigationBarContainerColor = MaterialTheme.colorScheme.surfaceContainer,
    shortNavigationBarContentColor = MaterialTheme.colorScheme.surfaceContainer,
    navigationBarContainerColor = MaterialTheme.colorScheme.surfaceContainer,
    navigationBarContentColor = MaterialTheme.colorScheme.surfaceContainer,
    navigationRailContainerColor = MaterialTheme.colorScheme.surfaceContainer,
    navigationRailContentColor = MaterialTheme.colorScheme.onSurface,
    wideNavigationRailColors = WideNavigationRailDefaults.colors(
        contentColor = MaterialTheme.colorScheme.surfaceContainer,
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
    ),
    navigationDrawerContentColor = MaterialTheme.colorScheme.surfaceContainer,
    navigationDrawerContainerColor = MaterialTheme.colorScheme.surfaceContainer,
)

@Composable
fun navigationItemColors() = NavigationRailItemColors(
    selectedIndicatorColor = MaterialTheme.colorScheme.secondaryContainer,
    selectedTextColor = MaterialTheme.colorScheme.secondary,
    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    disabledIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
    disabledTextColor = MaterialTheme.colorScheme.background,
)

@Composable
fun navigationSuiteType(adaptiveInfo: WindowAdaptiveInfo) =
    with(adaptiveInfo.windowSizeClass) {
        when (minWidthDp) {
            in 0 until 600 -> {
                NavigationSuiteType.ShortNavigationBarCompact
            }

            in 600 until 800 -> {
                NavigationSuiteType.NavigationRail
            }

            else -> NavigationSuiteType.WideNavigationRailCollapsed
        }
    }

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Modifier.navigationSuite() = fillMaxSize()
    .background(color = MaterialTheme.colorScheme.secondaryContainer)
    .verticalScroll(rememberScrollState())
    .windowInsetsPadding(WindowInsets.statusBarsIgnoringVisibility)
    .windowInsetsPadding(WindowInsets.displayCutout)