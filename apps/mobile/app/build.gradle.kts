plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin.dependencies)
    alias(libs.plugins.android.ui.compose)
    alias(libs.plugins.android.ui.libraries)
    alias(libs.plugins.android.dependency.injection)
}

android {
    namespace = "com.otterland.playground"

    defaultConfig {
        applicationId = "com.otterland.playground"
        versionCode = 2500000
        versionName = "25.0.000"
    }

    buildTypes {
        signingConfigs {
            maybeCreate("debug").apply {

            }
            maybeCreate("release").apply {

            }
        }

        defaultConfig {
            targetSdk = 36
        }

        debug {
            isDefault = true
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        compose = true
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(project(":libs:foundation:design"))
    implementation(project(":libs:foundation:permission"))

    implementation(project(":libs:imageloader:api"))
    implementation(project(":libs:imageloader:coil:ui"))
    implementation(project(":libs:imageloader:coil:network:api"))
    implementation(project(":libs:imageloader:coil:network:okhttp"))
    implementation(project(":libs:imageloader:coil:core"))

    implementation(project(":libs:foundation:network:api"))
    implementation(project(":libs:foundation:network:okhttp"))
    implementation(project(":libs:foundation:systeminfo"))

    implementation(project(":feature:systeminfo"))

    implementation(libs.androidx.spashscreen)
}