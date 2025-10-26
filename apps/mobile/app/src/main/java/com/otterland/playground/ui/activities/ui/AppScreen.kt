package com.otterland.OtterLand.ui.activities.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import com.otterland.playground.ui.activities.navigation.createNavHost

@Preview
@Composable
fun OtterLandAppPreview() {
    OtterLandApp()
}

@Composable
fun OtterLandApp(){
    val navHost = createNavHost()
    Scaffold(
        topBar = { OtterLandTopBar() },
        bottomBar = { OtterLandBottomBar() },
    ) { innerPadding ->
        OtterLandHomeScreen()
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