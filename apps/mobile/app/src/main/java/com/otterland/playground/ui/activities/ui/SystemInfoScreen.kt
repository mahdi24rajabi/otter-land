package com.otterland.playground.ui.activities.ui

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.PaneScaffoldDirective
import androidx.compose.material3.adaptive.layout.ThreePaneScaffoldScope
import androidx.compose.material3.adaptive.navigation.BackNavigationBehavior
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@Composable
@Preview
fun SystemInfoScreenPreview(){
    SystemInfoScreen()
}

enum class SystemInfoType {
    CPU
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SystemInfoScreen() {
    val listNavigator = rememberListDetailPaneScaffoldNavigator<SystemInfoType>()

    NavigableListDetailPaneScaffold(
        navigator = listNavigator,
        defaultBackBehavior = BackNavigationBehavior.Companion.PopUntilScaffoldValueChange,
        listPane = {
            AnimatedPane{

            }
        },
        detailPane = {
            AnimatedPane {

            }
        }
    )
}