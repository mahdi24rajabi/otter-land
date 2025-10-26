package com.otterland.OtterLand.ui.activities.ui

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.navigation.createNavHost

@Preview
@Composable
fun OtterLandAppPreview() {
    OtterLandApp()
}

@Composable
fun OtterLandApp(){
    val navHost = createNavHost()
    OtterLandTheme {
        Scaffold(
            topBar = { OtterLandTopBar() },
            bottomBar = { OtterLandBottomBar() },
        ) { innerPadding ->
            OtterLandHomeScreen()
        }
    }
}

@Composable
fun OtterLandTopBar() {

}

@Composable
fun OtterLandBottomBar() {

}

@Composable
fun OtterLandHomeScreen(){

}