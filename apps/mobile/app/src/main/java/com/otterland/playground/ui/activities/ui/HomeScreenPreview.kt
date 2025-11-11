package com.otterland.playground.ui.activities.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.otterland.foundation.design.theme.OtterLandTheme

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

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = "spec:width=1920dp,height=1080dp,dpi=160",
)
fun MediumHomeScreenPreview() {
    OtterLandTheme {
        HomeScreen()
    }
}