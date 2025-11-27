package com.otterland.playground.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.foundation.imageloader.coil.core.CoilNetworkImageLoader
import com.otterland.foundation.design.theme.OtterLandTheme
import com.otterland.playground.ui.activities.ui.screen.AppScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtterLandActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: CoilNetworkImageLoader

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