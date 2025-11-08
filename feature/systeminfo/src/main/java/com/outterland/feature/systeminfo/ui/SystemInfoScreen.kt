package com.outterland.feature.systeminfo.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.BackNavigationBehavior
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.outterland.feature.systeminfo.R

@Composable
@Preview
fun SystemInfoScreenPreview() {
    SystemInfoScreen()
}

enum class Category(
    val iconResourceId: Int
) {
    CPU(R.drawable.ic_cpu),
    Display(R.drawable.ic_display),
    Network(R.drawable.ic_network),
    MediaCodecs(R.drawable.ic_mediacodec),
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SystemInfoScreen() {
    val listNavigator = rememberListDetailPaneScaffoldNavigator<Category>()

    NavigableListDetailPaneScaffold(
        navigator = listNavigator,
        defaultBackBehavior = BackNavigationBehavior.Companion.PopUntilScaffoldValueChange,
        listPane = {
            AnimatedPane {
                Category.entries.forEachIndexed { index, category ->

                    Icon(
                        painter = painterResource(category.iconResourceId),
                        contentDescription = "",
                    )
                }
            }
        },
        detailPane = {
            AnimatedPane {

            }
        }
    )
}