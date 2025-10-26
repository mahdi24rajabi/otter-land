package com.otterland.playground.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.foundation.imageloader.coil.core.CoilNetworkImageLoader
import com.otterland.OtterLand.ui.activities.ui.OtterLandApp
import com.otterland.foundation.design.theme.OtterLandTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtterLandActivity : ComponentActivity() {

    @Inject lateinit var imageLoader: CoilNetworkImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            OtterLandApp()
        }
    }
}