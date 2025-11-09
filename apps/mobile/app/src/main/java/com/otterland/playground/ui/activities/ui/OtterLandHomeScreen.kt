package com.otterland.playground.ui.activities.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.WideNavigationRailDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.R
import com.outterland.feature.systeminfo.ui.SystemInfoScreen


enum class NavigationItems(
    val iconResource: Int,
    val label: String,
) {
    SYSTEM_INFO(
        iconResource = R.drawable.navigationbar_info,
        label = "Information",
    ),
    FIREBASE(
        iconResource = R.drawable.navigationbar_firebase,
        label = "Firebase",
    ),
    MEDIA(
        iconResource = R.drawable.navigationbar_media,
        label = "Media",
    ),
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_DESK,
    device = "id:Nexus S",
)
fun OtterLandHomeScreenPreview() {
    OtterLandTheme {
        OtterLandHomeScreen()
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = "spec:width=1920dp,height=1080dp,dpi=160",
)
fun OtterLandMediumHomeScreenPreview() {
    OtterLandTheme {
        OtterLandHomeScreen()
    }
}

@Composable
fun OtterLandHomeScreen(
    adaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(true),
) {
    var currentNavigationItem by rememberSaveable { mutableStateOf(NavigationItems.SYSTEM_INFO) }

    val navigationSuiteColor = NavigationSuiteDefaults.colors(
        shortNavigationBarContainerColor = MaterialTheme.colorScheme.surfaceContainer,
        shortNavigationBarContentColor = MaterialTheme.colorScheme.surfaceContainer,
        navigationBarContainerColor = MaterialTheme.colorScheme.surfaceContainer,
        navigationBarContentColor = MaterialTheme.colorScheme.surfaceContainer,
        navigationRailContainerColor = MaterialTheme.colorScheme.errorContainer,
        navigationRailContentColor = MaterialTheme.colorScheme.onSurface,
        wideNavigationRailColors = WideNavigationRailDefaults.colors(
            contentColor = MaterialTheme.colorScheme.surfaceContainer,
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        navigationDrawerContentColor = MaterialTheme.colorScheme.surfaceContainer,
        navigationDrawerContainerColor = MaterialTheme.colorScheme.surfaceContainer,
    )

    val navigationItemColors = NavigationRailItemColors(
        selectedIndicatorColor = MaterialTheme.colorScheme.secondaryContainer,
        selectedTextColor = MaterialTheme.colorScheme.secondary,
        selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledTextColor = MaterialTheme.colorScheme.background,
    )

    val navigationSuiteType =
        with(adaptiveInfo.windowSizeClass) {
            when (minWidthDp) {
                in 0 until 600 -> {
                    NavigationSuiteType.ShortNavigationBarCompact
                }

                in 600 until 800 -> {
                    NavigationSuiteType.ShortNavigationBarMedium
                }

                else -> NavigationSuiteType.WideNavigationRailCollapsed
            }
        }

    NavigationSuiteScaffold(
        navigationItems = {
            NavigationItems.entries.forEach { value ->
                NavigationRailItem(
                    icon = {
                        Icon(
                            painter = painterResource(value.iconResource),
                            contentDescription = ""
                        )
                    },
                    selected = currentNavigationItem == value,
                    enabled = true,
                    onClick = {
                        currentNavigationItem = value
                    },
                    alwaysShowLabel = true,
                    colors = navigationItemColors,
                    label = {
                        Text(value.label)
                    },
                )
            }
        },
        navigationSuiteType = navigationSuiteType,
        navigationSuiteColors = navigationSuiteColor,
        navigationItemVerticalArrangement = NavigationSuiteDefaults.verticalArrangement,
        primaryActionContent = {},
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .verticalScroll(rememberScrollState())
                .padding(
                    top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                    bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
                    start = 16.dp,
                    end = 16.dp
                )
        ){
            when (currentNavigationItem) {
                NavigationItems.SYSTEM_INFO -> {
                    SystemInfoScreen()
                }
                NavigationItems.FIREBASE -> {}
                NavigationItems.MEDIA -> {}
            }
        }
    }
}