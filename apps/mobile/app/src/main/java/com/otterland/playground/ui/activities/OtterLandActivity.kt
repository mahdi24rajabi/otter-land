package com.otterland.playground.ui.activities

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewGroupCompat
import androidx.core.view.WindowCompat
import com.foundation.imageloader.coil.core.CoilNetworkImageLoader
import com.otterland.OtterLand.ui.activities.ui.OtterLandApp
import com.otterland.foundation.design.theme.OtterLandTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtterLandActivity : ComponentActivity() {

    @Inject lateinit var imageLoader: CoilNetworkImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        installSplashScreen()

        setContent {
            OtterLandTheme {
                OtterLandApp()
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        } else {
            window.navigationBarColor = Color.TRANSPARENT
        }
    }
}