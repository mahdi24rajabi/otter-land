package com.otterland.playground.ui.activities.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.otterland.playground.ui.activities.ui.design.navigationItemColors

@Composable
fun NavigationItem(
    iconResourceId: Int,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    NavigationRailItem(
        icon = {
            Icon(
                painter = painterResource(iconResourceId),
                contentDescription = ""
            )
        },
        selected = selected,
        enabled = true,
        onClick = {
            onClick()
        },
        alwaysShowLabel = true,
        colors = navigationItemColors(),
        label = {
            Text(label)
        },
    )
}