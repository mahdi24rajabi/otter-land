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
        targetSdk = 36
    }

    signingConfigs {
        maybeCreate("debug").apply {
            storeFile = file( "../../../key_stores/debug_key.jks")
            keyAlias = "otterland_debug"
            keyPassword = "Test2025"
            storePassword = "Test2025"
        }
        maybeCreate("release").apply {
            storeFile = file("../../../key_stores/debug_key.jks")
            keyAlias = "otterland_debug"
            keyPassword = "Test2025"
            storePassword = "Test2025"
        }
    }

    buildTypes {

        maybeCreate("debug").apply {
            isDefault = true
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }

        maybeCreate("release").apply {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        create("benchmark") {
            initWith(getByName("release"))
            isProfileable = true
            matchingFallbacks += listOf("release")
            signingConfig = signingConfigs.getByName("debug")
        }

    }

    buildFeatures {
        compose = true
    }

    hilt {
        enableAggregatingTask = true
    }

    packaging {
        resources {
            excludes += setOf(
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/LICENSE.md",
                "META-INF/NOTICE",
                "META-INF/NOTICE.txt",
                "META-INF/NOTICE.md"
            )
        }
    }
}

dependencies {
    implementation(project(":feature:systeminfo"))

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

    implementation(libs.androidx.spashscreen)
}