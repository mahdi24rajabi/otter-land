package com.otterland.playground.ui.activities.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.otterland.imageloader.design.theme.OtterLandTheme
import com.otterland.playground.R
import com.otterland.playground.ui.activities.ui.component.NavigationItem
import com.otterland.playground.ui.activities.ui.design.navigationSuite
import com.otterland.playground.ui.activities.ui.design.navigationSuiteColors
import com.otterland.playground.ui.activities.ui.design.navigationSuiteType
import com.otterland.feature.systeminfo.ui.navigation.SystemInfoNavHost
import kotlinx.coroutines.launch

enum class NavigationItemModel(
    val iconResource: Int,
    val label: String,
    val screen: @Composable () -> Unit
) {
    SYSTEM_INFO(
        iconResource = R.drawable.navigationbar_info,
        label = "Information",
        screen = { SystemInfoNavHost() }
    ),
    FIREBASE(
        iconResource = R.drawable.navigationbar_firebase,
        label = "Firebase",
        screen = {}
    ),
    MEDIA(
        iconResource = R.drawable.navigationbar_media,
        label = "Media",
        screen = {}
    ),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    adaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(true),
) {
    var currentNavigationItem by rememberSaveable { mutableStateOf(NavigationItemModel.SYSTEM_INFO) }
    val scope = rememberCoroutineScope()

    val navigationSuiteColor = navigationSuiteColors()
    val navigationSuiteType = navigationSuiteType(adaptiveInfo)

    NavigationSuiteScaffold(
        navigationItems = {
            NavigationItemModel.entries.forEach { item ->
                NavigationItem(
                    iconResourceId = item.iconResource,
                    label = item.label,
                    selected = currentNavigationItem == item,
                ) {
                    scope.launch { currentNavigationItem = item }
                }
            }
        },
        navigationSuiteType = navigationSuiteType,
        navigationSuiteColors = navigationSuiteColor,
        navigationItemVerticalArrangement = NavigationSuiteDefaults.verticalArrangement,
        primaryActionContent = {},
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.navigationSuite()
        ) {
            currentNavigationItem.screen()
        }
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_DESK,
    device = "id:Nexus S",
)
fun HomeScreenPreview() {
    OtterLandTheme {
        HomeScreen()
    }
}