package com.otterland.playground.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.otterland.imageloader.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.screen.AppScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtterLandActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        installSplashScreen()

        setContent {
            OtterLandTheme {
                AppScreen()
            }
        }
    }
}