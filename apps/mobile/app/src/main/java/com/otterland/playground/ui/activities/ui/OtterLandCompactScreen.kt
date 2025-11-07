package com.otterland.playground.ui.activities.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_TYPE_TELEVISION
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices.PIXEL
import androidx.compose.ui.tooling.preview.Devices.TV_1080p
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.core.layout.WindowSizeClass
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.R


enum class NavigationItems(
    val iconResource: Int,
) {
    SYSTEM_INFO(
        iconResource = R.drawable.navigationbar_info
    ),
    FIREBASE(
        iconResource = R.drawable.navigationbar_firebase
    ),
    MEDIA(
        iconResource = R.drawable.navigationbar_media
    ),
}

@Composable
@Preview(
    uiMode = UI_MODE_TYPE_TELEVISION,
    device = TV_1080p
)
fun OtterLandCompactTVScreenPreview() {
    OtterLandTheme {
        OtterLandAppScreen()
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = PIXEL
)
fun OtterLandCompactMobileScreenPreview() {
    OtterLandTheme {
        OtterLandAppScreen()
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = "spec:parent=pixel_tablet,navigation=buttons",
)
fun OtterLandCompactTabletScreenPreview() {
    OtterLandTheme {
        OtterLandAppScreen()
    }
}

@Composable
fun OtterLandAppScreen(
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo(true).windowSizeClass
) {
    var currentNavigationItem by rememberSaveable { mutableStateOf(NavigationItems.SYSTEM_INFO) }

    val navigationColors = NavigationSuiteDefaults.colors(
        navigationBarContainerColor = MaterialTheme.colorScheme.onPrimary,
        navigationBarContentColor = MaterialTheme.colorScheme.primary,
    )

    val navigationItemColors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            disabledIconColor = MaterialTheme.colorScheme.onSurface,
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            indicatorColor = MaterialTheme.colorScheme.secondary,
        )
    )

    val navigationSuiteType = when {
        windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) -> {
            NavigationSuiteType.NavigationRail
        }

        windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND) -> {
            NavigationSuiteType.WideNavigationRailCollapsed
        }

        else -> NavigationSuiteType.NavigationBar
    }

    NavigationSuiteScaffold(
        layoutType = navigationSuiteType,
        contentColor = MaterialTheme.colorScheme.background,
        containerColor = MaterialTheme.colorScheme.onBackground,
        navigationSuiteColors = navigationColors,
        navigationSuiteItems = {
            NavigationItems.entries.forEach { value ->
                item(
                    icon = {
                        Icon(painter = painterResource(value.iconResource), contentDescription = "")
                    },
                    selected = currentNavigationItem == value,
                    enabled = true,
                    onClick = {
                        currentNavigationItem = value
                    },
                    colors = navigationItemColors
                )
            }
        },
    ) {
        when (currentNavigationItem) {
            NavigationItems.SYSTEM_INFO -> {}
            NavigationItems.FIREBASE -> {}
            else -> {}
        }
    }
}